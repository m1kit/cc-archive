package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BOneClue {

    private static final int RANGE = 1000000;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int k = in.ints(), x = in.ints();
        for (int i = Math.max(-RANGE, x - k + 1); i <= Math.min(RANGE, x + k - 1); i++) out.ans(i);
        out.ln();
    }
}
