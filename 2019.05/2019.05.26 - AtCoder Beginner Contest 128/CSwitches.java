package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CSwitches {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int[][] s = new int[m][];
        for (int i = 0; i < m; i++) {
            int k = in.ints();
            s[i] = new int[k];
            for (int j = 0; j < k; j++) {
                s[i][j] = in.ints() - 1;
            }
        }
        int[] p = in.ints(m);
        int ans = 0;
        outer: for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 0;
                for (int k : s[j]) {
                    if ((i & (1 << k)) != 0) count++;
                }
                if (count % 2 != p[j]) continue outer;
            }
            ans++;
        }
        out.ans(ans).ln();
    }
}
