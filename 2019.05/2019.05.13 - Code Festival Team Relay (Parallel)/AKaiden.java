package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AKaiden {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long k = in.longs(), a = in.longs(), b = in.longs();
        if (k <= a) {
            out.ans(1).ln();
        } else if (a - b <= 0) {
            out.ans(-1).ln();
        } else {
            out.ans((k - b - 1) / (a - b) * 2 + 1).ln();
        }
    }
}
