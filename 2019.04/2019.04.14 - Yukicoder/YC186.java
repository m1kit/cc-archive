package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.LongChineseRemainder;

public class YC186 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        LongChineseRemainder cr = new LongChineseRemainder();
        try {
            for (int i = 0; i < 3; i++) {
                long x = in.longs(), y = in.longs();
                cr.grow(x, y);
            }
            out.ansln(cr.getR());
        } catch (IllegalStateException ex) {
            out.ansln(-1);
        }
    }
}
