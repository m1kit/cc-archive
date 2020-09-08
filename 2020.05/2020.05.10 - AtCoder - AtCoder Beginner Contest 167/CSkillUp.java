package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CSkillUp {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(), x = in.ints(), ans = 1_000_000_000;
        int[] c = new int[n];
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            c[i] = in.ints();
            a[i] = in.ints(m);
        }
        loop: for (int i = 0; i < 1 << n; i++) {
            int t = i, cost = 0;
            int[] count = new int[m];
            for (int j = 0; j < n; j++) {
                if (t % 2 == 1) {
                    cost += c[j];
                    for (int k = 0; k < m; k++) count[k] += a[j][k];
                }
                t /= 2;
            }
            for (int j = 0; j < m; j++) {
                if (count[j] < x) continue loop;
            }
            ans = Math.min(ans, cost);
        }
        out.ans(ans >= 1_000_000_000 ? -1 : ans).ln();
    }
}
