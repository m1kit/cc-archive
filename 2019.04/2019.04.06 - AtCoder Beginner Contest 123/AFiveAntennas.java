package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AFiveAntennas {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int[] a = in.ints(5);
        int k = in.ints();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if (Math.abs(a[i] - a[j]) > k) {
                    out.ansln(":(");
                    return;
                }
            }
        }
        out.ansln("Yay!");
    }
}
