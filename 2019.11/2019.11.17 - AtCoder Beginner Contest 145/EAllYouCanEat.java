package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class EAllYouCanEat {

    private static final int MAX = 3333;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), t = in.ints();
        int[] cost = new int[n], gain = new int[n];
        in.ints(cost, gain);
        int[][] left = new int[n + 1][MAX], right = new int[n + 1][MAX];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < MAX; j++)
                left[i + 1][j] = left[i][j];
            for (int j = 0; j < MAX - cost[i]; j++)
                left[i + 1][j + cost[i]] = Math.max(left[i + 1][j + cost[i]], left[i][j] + gain[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < MAX; j++)
                right[i][j] = right[i + 1][j];
            for (int j = 0; j < MAX - cost[i]; j++)
                right[i][j + cost[i]] = Math.max(right[i][j + cost[i]], right[i + 1][j] + gain[i]);
        }
        long ans = left[n][t];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < t; j++)
                ans = Math.max(ans, gain[i] + left[i][j] + right[i + 1][t - j - 1]);
        out.ans(ans).ln();
    }
}
