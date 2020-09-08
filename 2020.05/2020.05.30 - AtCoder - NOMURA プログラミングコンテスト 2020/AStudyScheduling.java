package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AStudyScheduling {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int h1 = in.ints(), m1 = in.ints(), h2 = in.ints(), m2 = in.ints();
        int d = (h2 - h1) * 60 + m2 - m1;
        out.ans(d - in.ints()).ln();
    }
}
