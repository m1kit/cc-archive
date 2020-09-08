package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    private static int[][] b, c;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        b = in.ints(2, 3);
        c = in.ints(3, 2);
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sum += b[i][j];
                sum += c[j][i];
            }
        }
        int ans = dfs(new int[3][3], 0);
        out.ans(ans).ln().ans(sum - ans).ln();
    }

    private static int dfs(int[][] a, int filled) {
        if (filled == 9) {
            int res = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    if (a[j][i] == a[j + 1][i]) res += b[j][i];
                    if (a[i][j] == a[i][j + 1]) res += c[i][j];
                }
            }
            return res;
        }
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] != 0) continue;
                a[i][j] = filled % 2 + 1;
                int res = dfs(a, filled + 1);
                min = Math.min(min, res);
                max = Math.max(max, res);
                a[i][j] = 0;
            }
        }
        return filled % 2 == 0 ? max : min;
    }

}
