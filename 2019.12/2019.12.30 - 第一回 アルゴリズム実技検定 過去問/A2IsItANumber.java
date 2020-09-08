package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A2IsItANumber {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        try {
            out.ans(in.ints() * 2).ln();
        } catch (RuntimeException ex) {
            out.ans("error").ln();
        }
    }
}
