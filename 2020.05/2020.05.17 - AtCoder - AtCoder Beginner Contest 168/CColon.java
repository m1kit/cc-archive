package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CColon {

    private static final double PI2 = 2 * Math.PI;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        // out.setCaseLabel(LightWriter.CaseLabel.NONE);
        double a = in.doubles(), b = in.doubles(), h = in.doubles(), m = in.doubles();
        double d = Math.abs((PI2 * (h + m / 60) / 12) - (PI2 * m / 60));
        double t = Math.min(PI2 - d, d);
        //System.out.println(t / PI2 * 360); // 10
        out.ans(Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(t)), 20).ln();
    }
}
