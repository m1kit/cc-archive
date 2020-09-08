package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;

import java.util.Arrays;

public class ECommonSubsequence {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        int[] s = in.ints(n), t = in.ints(m);

        IntSegmentTree st = new IntSegmentTree(new long[m + 1], (x, y) -> (x + y) % MOD, 0, (x, u) -> (x + u) % MOD);
        long[][] dp = new long[n + 1][m + 1];
        dp[0][0] = 1;
        st.update(0, 1);
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (s[i] != t[j]) continue;
                dp[i + 1][j + 1] = st.query(0, j + 1);
                st.update(j + 1, dp[i + 1][j + 1]);
            }
        }

        //Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);

        out.ans(st.query(0, m + 2)).ln();
    }
}
