package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BKnights {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(i % 2 == 0 && j % 2 == 0 ? 'W' : 'B');
            }
            out.ln();
        }
    }
}
