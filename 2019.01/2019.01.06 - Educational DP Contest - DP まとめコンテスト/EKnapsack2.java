package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.math.IntMath;
import jp.llv.atcoder.lib.structure.vector.Vec2i;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EKnapsack2 {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), wa = in.ints();
        int[] w = new int[n], v = new int[n];
        in.ints(w, v);
        int vmax = 1000_01;
        long[][] dp = new long[n + 1][vmax];
        ArrayUtil.fill(dp, 1000_000_000_000_000L);
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < vmax; j++) {
                if (j >= v[i]) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j - v[i]] + w[i]);
                }
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
            }
        }
        for (int i = vmax - 1; i >= 0; i--) {
            if (dp[n][i] <= wa) {
                out.ans(i).ln();
                return;
            }
        }

    }

}

