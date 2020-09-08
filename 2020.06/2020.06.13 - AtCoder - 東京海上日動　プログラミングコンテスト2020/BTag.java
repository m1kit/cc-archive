package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BTag {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        long a = in.longs(), v = in.longs(), b = in.longs(), w = in.longs(), t = in.longs();
        long d = Math.abs(a - b), s = v - w;
        if (s < 0) {
            out.noln();
        } else out.ans(d <= s * t).ln();
    }
}
