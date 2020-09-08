package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        if        (s.equals("Monday")) {
            out.ans(5).ln();
        } else if (s.equals("Tuesday")) {
            out.ans(4).ln();
        } else if (s.equals("Wednesday")) {
            out.ans(3).ln();
        } else if (s.equals("Thursday")) {
            out.ans(2).ln();
        } else if (s.equals("Friday")) {
            out.ans(1).ln();
        } else {
            out.ans(0).ln();
        }
    }
}
