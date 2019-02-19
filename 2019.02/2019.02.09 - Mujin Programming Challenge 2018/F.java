package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.mod.Factorial;
import jp.llv.atcoder.lib.math.mod.ModMath;

public class F {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        int[] c = new int[n + 1];
        for (int i = 0; i < n; i++) {
            c[in.ints()]++;
        }
        ModMath mod = new ModMath(MOD);
        Factorial fact = mod.getFactorial(n + 1);

        long[][] dp = new long[n + 2][n + 1];
        dp[n + 1][0] = 1;
        for (int i = n; i >= 1; i--) {
            for (int j = 0; c[i] + j <= n; j++) {
                long p = 1;
                int d = 0;
                for (int r = c[i] + j; 0 <= r; r -= i) {
                    // System.out.println(i+","+j+","+r);
                    dp[i][r] += (dp[i + 1][j] * p) % MOD * fact.factinv(d);
                    dp[i][r] %= MOD;
                    p *= fact.ncr(r, i);
                    p %= MOD;
                    d++;
                }
            }
        }
        out.ans(dp[1][0]).ln();
    }
}
