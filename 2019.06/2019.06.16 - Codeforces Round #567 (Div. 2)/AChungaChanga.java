package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AChungaChanga {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long x = in.longs(), y = in.longs(), z = in.longs();
        out.ans((x + y) / z).ans(
                x / z + y / z == (x + y) / z ? 0
                        : Math.min(z - x % z, z - y % z)
        ).ln();

        long a = x / z, b = y / z, c = (x + y) / z;
        if (a + b == c) {
            System.out.println(c + " " + 0);
        } else {
            long a1 = x % z, a2 = y % z, r;
            if (a1 < a2) {
                r = a1;
            } else {
                r = a2;
            }
            r -= (x + y) % z;
            System.out.println(c + " " + r);
        }
    }
}
