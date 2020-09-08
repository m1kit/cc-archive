package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class DRestoringRoadNetwork {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[][] a = in.ints(n, n);
        boolean[][] exist = new boolean[n][n];
        ArrayUtil.fill(exist, true);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == j || j == k) continue;
                    if (a[i][j] + a[j][k] < a[i][k]) {
                        out.ans(-1).ln();
                        return;
                    } else if (a[i][j] + a[j][k] == a[i][k]) {
                        exist[i][k] = false;
                    }
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (exist[i][j]) {
                    ans += a[i][j];
                }
            }
        }
        out.ans(ans).ln();
    }
}
