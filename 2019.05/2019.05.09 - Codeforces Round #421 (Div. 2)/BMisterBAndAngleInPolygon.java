package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BMisterBAndAngleInPolygon {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        double n = in.ints(), a = in.ints();
        // 0 <-> j <-> i
        int mini = -1;
        double min = Double.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            double angle = 180 * i / n;
            if (Math.abs(a - angle) < min) {
                min = Math.abs(a - angle);
                mini = i;
            }
        }
        out.ans(1).ans(mini + 2).ans(mini + 1).ln();
    }
}
