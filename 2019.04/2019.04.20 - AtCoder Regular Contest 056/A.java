package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long a = in.longs(), b = in.longs(), k = in.longs(), l = in.longs();

        long ans = Math.min(((k / l)* b) + ((k % l) * a), (k + l - 1) / l * b);
        out.ansln(ans);
    }
}
