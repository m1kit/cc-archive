package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class FBraveCHAIN {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = new int[3 * n];
        for (int i = 0; i < 3 * n; i++) a[i] = in.ints() - 1;
        //if (n >= 500 )throw new RuntimeException();
        int all = 0;
        int[][] dp = new int[n][n];
        ArrayUtil.fill(dp, -50000);
        dp[a[0]][a[1]] = dp[a[1]][a[0]] = 0;
        int[] m2 = new int[n];
        Arrays.fill(m2, -50000);
        m2[a[0]] = m2[a[1]] = 0;
        int cur = 0, max = 0;
        int[] dx = new int[8 * n], dy = new int[8 * n], nv = new int[8 * n];
        int[] t = new int[3];
        for (int i = 1; i < n; i++) {
            cur = 0;
            t[0] = a[3 * i - 1];
            t[1] = a[3 * i];
            t[2] = a[3 * i + 1];
            // x y Z Z Z => [Z Z Z] x y
            if (t[0] == t[1] && t[1] == t[2]) {
                all++;
                continue;
            }
            for (int j = 0; j < 3; j++) {
                for (int o1 = 0; o1 < n; o1++) {
                    // v w X Y Z => (w Y Z) v X
                    dx[cur] = t[j];
                    dy[cur] = o1;
                    nv[cur++] = m2[o1];
                }
            }
            for (int j = 0; j < 3; j++) {
                int o1 = t[(j + 1) % 3], o2 = t[(j + 2) % 3];
                // x x X Y Z => [x x X] Y Z
                dx[cur] = o1;
                dy[cur] = o2;
                nv[cur++] = dp[t[j]][t[j]] + 1;
                // v w X Y Z => (v w X) Y Z
                dx[cur] = o1;
                dy[cur] = o2;
                nv[cur++] = max;
            }
            for (int j = 0; j < 3; j++) {
                int s1 = t[(j + 1) % 3], s2 = t[(j + 2) % 3];
                if (s1 != s2) continue;
                int o1 = t[j];
                for (int o2 = 0; o2 < n; o2++) {
                    // x y X X Z => [x X X] y Z
                    dx[cur] = o1;
                    dy[cur] = o2;
                    nv[cur++] = dp[s1][o2] + 1;
                }
            }
            for (int j = 0; j < cur; j++) {
                if (nv[j] < 0) continue;
                dp[dx[j]][dy[j]] = dp[dy[j]][dx[j]] = Math.max(dp[dy[j]][dx[j]], nv[j]);
                max = Math.max(max, nv[j]);
                m2[dx[j]] = Math.max(m2[dx[j]], nv[j]);
                m2[dy[j]] = Math.max(m2[dy[j]], nv[j]);

            }
        }
        int last = a[3 * n - 1];
        out.ans(Math.max(dp[last][last] + 1, max) + all).ln();
    }
}
