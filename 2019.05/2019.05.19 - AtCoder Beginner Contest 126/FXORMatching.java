package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.stream.IntStream;

public class FXORMatching {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int m = in.ints(), k = in.ints();
        int n = 1 << m;

        if (k == 0) {
            for (int i = 0; i < n; i++) {
                out.ans(i).ans(i);
            }
            out.ln();
            return;
        }

        int v = 0;
        for (int i = 0; i < n; i++) {
            if (i != k) v ^= i;
        }
        if (v != k) {
            out.ans(-1).ln();
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i != k) out.ans(i);
        }
        out.ans(k);
        for (int i = 0; i < n; i++) {
            if (i != k) out.ans(i);
        }
        out.ans(k).ln();
    }
}
