package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ARegistration {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        String s1=in.string(),s2=in.string();
        out.ans(s2.startsWith(s1)).ln();
    }
}
