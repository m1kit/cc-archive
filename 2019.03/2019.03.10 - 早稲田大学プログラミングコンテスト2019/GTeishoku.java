package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class GTeishoku {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    static int n, m;
    static long[][] cost;
    static long[] dp;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        n = in.ints();
        m = in.ints();
        int[] a = in.ints(m);

        cost = new long[n][n]; //[i][j] iを提供した時にjの被るストレス
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int c = 0;
                for (int k = 0; k < m; k++) {
                    if (a[k] == i) {
                        c++;
                    } else if (a[k] == j) {
                        cost[i][j] += c;
                    }
                }
            }
        }

        dp = new long[1 << n];
        Arrays.fill(dp, -1);
        out.ansln(calc((1 << n) - 1));
    }

    private static long calc(int set) {
        if (set == 0) {
            return 0;
        } else if (dp[set] >= 0) {
            return dp[set];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (((1 << i) & set) == 0) {
                continue;
            }
            int pre = set & (~(1 << i));
            long c = calc(pre);
            for (int j = 0; j < n; j++) {
                if (((1 << j) & pre) != 0) {
                    continue;
                }
                c += cost[i][j];
            }
            ans = Math.min(ans, c);
        }
        return dp[set] = ans;
    }
}
