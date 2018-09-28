package jp.llv.atcoder;

import java.util.*;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    private static int n;
    private static int[] a;
    private static int[][][] dp;
    private static int max = 3000;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        // INITIALIZE
        n = in.nextInt();
        // max = n * 60;
        int k = in.nextInt();
        a = IntStream.range(0, n).map(x -> {
            long i = in.nextLong();
            return i == 0 ? 0 : 1 + log(i);
        }).toArray();
        dp = new int[ZeroAcceptPolicy.values().length][n][max];
        for (int i = 0; i < dp.length; i++) {
            Arrays.stream(dp[i]).forEach(a -> Arrays.fill(a, -1));
        }

        // CALC
        out.println(dfs(ZeroAcceptPolicy.ALLOW, n - 1, k));
    }

    private static int dfs(ZeroAcceptPolicy p, int i, int k) {
        int ans;
        switch (p) {
            case DENY:
                if (k < 0 || max <= k || n < i) {
                    return 0;
                } else if (i < 0) {
                    return k == 0 ? 1 : 0;
                } else if (dp[p.ordinal()][i][k] >= 0) {
                    return dp[p.ordinal()][i][k];
                }
                ans = 0;
                for (int j = 0; j < a[i]; j++) {
                    ans += dfs(ZeroAcceptPolicy.DENY, i - 1, k - j);
                    ans %= MOD;
                }
                break;
            case REQUIRE:
                if (k < 0 || max <= k || n < i || i < 0) {
                    return 0;
                } else if (dp[p.ordinal()][i][k] >= 0) {
                    return dp[p.ordinal()][i][k];
                }
                ans = dfs(ZeroAcceptPolicy.DENY,i - 1, k - a[i]);
                for (int j = 0; j <= a[i]; j++) {
                    ans += dfs(ZeroAcceptPolicy.REQUIRE,i - 1, k - j);
                    ans %= MOD;
                }
                break;
            case ALLOW:
                ans = (int) (IntStream.rangeClosed(0, Math.min(k, max)).mapToLong(l -> dfs(ZeroAcceptPolicy.REQUIRE, n - 1, l)).sum() % MOD);
                ans += dfs(ZeroAcceptPolicy.DENY, i, k);
                ans %= MOD;
                return ans;
            default:
                throw new UnsupportedOperationException();
        }
        return dp[p.ordinal()][i][k] = ans;
    }

    private static int log(long v) {
        int ans = 0;
        for (; v > 1; ans++) {
            v = v >> 1;
        }
        return ans;
    }

    private enum ZeroAcceptPolicy {
        DENY, REQUIRE, ALLOW
    }
}
