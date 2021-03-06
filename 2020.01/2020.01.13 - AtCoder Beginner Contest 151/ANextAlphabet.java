package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ANextAlphabet {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.print((char) (in.string().toCharArray()[0] + 1)).ln();
    }
}
