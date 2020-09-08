package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;

import java.util.Arrays;
import java.util.stream.IntStream;

public class F1ShortColorfulStrip {

    private static final int MOD = 998244353;
    private static int[] c, left, right;
    private static int n, m;
    private static IntSegmentTree range;
    private static long[][] dp;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        n = in.ints();
        m = in.ints();
        c = in.ints(m);
        range = new IntSegmentTree(
                IntStream.of(c).mapToLong(i -> i - 1).toArray(),
                Math::min,
                Long.MAX_VALUE,
                Math::min
        );

        left = new int[n];
        Arrays.fill(left, -1);
        right = new int[n];
        Arrays.fill(right, -1);
        for (int i = 0; i < m; i++) {
            if (left[c[i] - 1] == -1) left[c[i] - 1] = i;
            right[c[i] - 1] = i;
        }

        int[] sum = new int[m + 1];
        for (int i = 0; i < n; i++) {
            sum[left[i]]++;
            sum[right[i] + 1]--;
        }
        for (int i = 1; i <= m; i++) {
            sum[i] += sum[i - 1];
        }

        dp = new long[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        out.ans(solve(0, n - 1)).ln();

        // validate
        /*
        IntSegmentTree st = new IntSegmentTree(IntStream.of(c).mapToLong(i -> i).toArray(), Math::range, Long.MAX_VALUE, Long::range);
        int[] left = new int[n + 1], right = new int[n + 1];
        Arrays.fill(left, - 1);
        Arrays.fill(right, -1);
        for (int i = 0; i < m; i++) {
            if (left[c[i]] == -1) left[c[i]] = i;
            right[c[i]] = i;
        }
        for (int i = 1; i <= n; i++) {
            if (st.query(left[i], right[i] + 1) < i) {
                out.ans(0).ln();
                return;
            }
        } */

        /*
        IntSegmentTree max = new IntSegmentTree(LongStream.range(0, m).map(i -> -1).toArray(), Math::max, -1, Math::max);
        IntSegmentTree range = new IntSegmentTree(LongStream.range(0, m).map(i -> m).toArray(), Math::max, m, Math::max);
        long ans = 1;
        for (int i = 0; i < n; i++) {
            long l = max.query(0, p[i]), r = range.query(p[i] + 1, m);
            System.out.println("i=" + i + " l=" + l + " r=" + r + " delta=" + (p[i] - l) * (r - p[i]));
            ans *= (p[i] - l) * (r - p[i]);
            ans %= MOD;
            max.update(p[i], i);
            range.update(p[i], i);
        }
        out.ans(ans).ln(); */
    }

    private static long solve(int l, int r) {
        if (r < 0 || n <= l || r <= l) return 1;
        if (dp[l][r] >= 0) return dp[l][r];
        int target = (int) range.query(l, r + 1);
        int index = 0;//p[target];
        //System.out.println("Calc: l="+l+" r="+r);
        long left = 0, right = 0;
        for (int cur = index; cur >= l && c[cur] >= target; cur--) {
            left += solve(l, cur - 1) * solve(cur, index - 1) % MOD;
            left %= MOD;
        }
        for (int cur = index; cur <= r && c[cur] >= target; cur++) {
            right += solve(index + 1, cur) * solve(cur + 1, r) % MOD;
            right %= MOD;
        }
        return dp[l][r] = (left * right) % MOD;
    }
}
