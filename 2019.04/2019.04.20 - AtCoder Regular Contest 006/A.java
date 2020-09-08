package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        boolean[] good = new boolean[10];
        for (int i = 0; i < 6; i++) {
            good[in.ints()] = true;
        }
        int b = in.ints();
        boolean f = false;
        int c = 0;
        for (int i = 0; i < 6; i++) {
            int a = in.ints();
            if (good[a]) {
                c++;
            } else if (a == b) {
                f = true;
            }
        }
        if (c == 6) {
            out.ans(1).ln();
        } else if (c == 5 && f) {
            out.ans(2).ln();
        } else if (c < 3) {
            out.ans(0).ln();
        } else {
            out.ans(8 - c).ln();
        }
    }
}
