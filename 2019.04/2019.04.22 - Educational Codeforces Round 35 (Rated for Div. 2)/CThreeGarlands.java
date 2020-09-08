package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CThreeGarlands {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int[] c = new int[1501];
        for (int i = 0; i < 3; i++) {
            c[in.ints()]++;
        }
        for (int i = 1500; i >= 2; i--) {
            if (i % 3 == 0 && c[i] == 3) {
                c[i] -= 3;
                c[i / 3]++;
            } else if (i % 2 == 0 && c[i] >= 2) {
                c[i] -= 2;
                c[i / 2]++;
            }
        }
        out.ans(c[1] >= 1).ln();
    }
}
