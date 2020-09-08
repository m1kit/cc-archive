package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BComparingStrings {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int a = in.ints(), b = in.ints();
        for (int i = 0; i < Math.max(a, b); i++) {
            out.print((char) (Math.min(a, b) + '0'));
        }
        out.ln();
    }
}
