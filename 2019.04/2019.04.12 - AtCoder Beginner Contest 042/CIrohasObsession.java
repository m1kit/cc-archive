package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CIrohasObsession {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int k = in.ints();
        boolean[] d = new boolean[10];
        for (int i = 0; i < k; i++) {
            d[in.ints()] = true;
        }

        outer: for (int i = n;; i++) {
            int t = i;
            while (t > 0) {
                if (d[t % 10]) {
                    continue outer;
                }
                t /= 10;
            }
            out.ansln(i);
            return;
        }
    }
}
