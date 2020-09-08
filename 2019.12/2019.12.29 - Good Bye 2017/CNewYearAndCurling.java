package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CNewYearAndCurling {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), r = in.ints();
        int[] x = in.ints(n);
        double[] ans = new double[n];
        for (int i = 0; i < n; i++) {
            double h = r;
            for (int j = 0; j < i; j++) {
                int d = Math.abs(x[i] - x[j]);
                if (d > 2 * r) continue;
                h = Math.max(h, ans[j] + Math.sqrt(4 * r * r - d * d));
            }
            ans[i] = h;
            out.ans(ans[i], 10);
        }
        out.ln();
    }
}
