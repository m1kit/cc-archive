package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CTaxIncrease {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int a = in.ints(), b = in.ints();
        for (int i = 0; i <= 100000; i++) {
            if ((i * 8) / 100 == a && (i * 10) / 100 == b) {
                out.ans(i).ln();
                return;
            }
        }
        out.ans(-1).ln();
    }
}
