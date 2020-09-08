package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AServalAndBus {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);

        int n = in.ints(), t = in.ints();
        int min = Integer.MAX_VALUE, idx = -1;
        for (int i = 0; i < n; i++) {
            int s = in.ints(), d = in.ints();
            while (s < t) {
                s += d;
            }
            int w = s - t;
            if (w < min) {
                min = w;
                idx = i + 1;
            }
        }
        out.ansln(idx);
    }
}
