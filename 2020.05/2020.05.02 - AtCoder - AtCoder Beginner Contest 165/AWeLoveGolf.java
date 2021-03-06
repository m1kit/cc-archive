package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AWeLoveGolf {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        // out.setCaseLabel(LightWriter.CaseLabel.NONE);
        int k = in.ints(), a = in.ints(), b = in.ints();
        for (int i = a; i <= b; i++) {
            if (i % k == 0) {
                out.ans("OK").ln();
                return;
            }
        }
        out.ans("NG").ln();
    }
}
