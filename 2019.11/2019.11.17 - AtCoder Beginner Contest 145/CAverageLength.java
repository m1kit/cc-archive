package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CAverageLength {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        double[] x = new double[n], y = new double[n];
        in.doubles(x, y);
        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                ans += Math.hypot(x[i] - x[j], y[i] - y[j]);
            }
        }
        ans /= n / 2.0;
        out.ans(ans, 10).ln();
    }
}
