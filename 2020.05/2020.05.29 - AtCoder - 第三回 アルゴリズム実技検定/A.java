package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        String s = in.string(), t = in.string();
        if (s.equals(t)) {
            out.ans("same").ln();
        } else if (s.equalsIgnoreCase(t)) {
            out.ans("case-insensitive").ln();
        } else {
            out.ans("different").ln();
        }
    }
}
