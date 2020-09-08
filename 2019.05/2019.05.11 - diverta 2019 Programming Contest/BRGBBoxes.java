package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BRGBBoxes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long[] a = in.longs(3);
        long n = in.longs();
        long ans = 0;
        for (int i = 0; i <= 3000; i++) {
            for (int j = 0; j <= 3000; j++) {
                long req = n - (a[0] * i) - (a[1] * j);
                if (req < 0 || req % a[2] != 0) continue;
                ans++;
            }
        }
        out.ans(ans).ln();
    }
}
