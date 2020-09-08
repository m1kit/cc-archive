package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BYYMMOrMMYY {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int x = Integer.parseInt(s.substring(0, 2)), y = Integer.parseInt(s.substring(2, 4));
        boolean f1 = 1 <= x && x <= 12, f2 = 1 <= y && y <= 12;
        if (f1 && f2) {
            out.ans("AMBIGUOUS").ln();
        } else if (f1) {
            out.ans("MMYY").ln();
        } else if (f2) {
            out.ans("YYMM").ln();
        } else {
            out.ans("NA").ln();
        }
    }
}
