package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class BReversi {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int originalN = in.ints();
        int[] c = new int[originalN];
        int n = 1;
        c[0] = in.ints();
        for (int i = 1; i < originalN; i++) {
            int col = in.ints();
            if (c[n - 1] == col) {
                continue;
            }
            c[n++] = col;
        }
        c = Arrays.copyOf(c, n);
        // 同じ色は連続しません

        long ans = 1;
        long[] dp = new long[200_001];
        for (int i = 0; i < n; i++) {
            long t = dp[c[i]];
            dp[c[i]] += ans;
            dp[c[i]] %= MOD;
            ans += t;
            ans %= MOD;
        }
        out.ansln(ans);
    }
}
