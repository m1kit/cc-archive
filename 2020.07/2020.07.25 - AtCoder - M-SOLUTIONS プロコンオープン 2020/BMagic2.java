package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BMagic2 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long a = in.longs(), b = in.longs(), c = in.longs(), cnt = 0, k = in.longs();
        while (a >= b) {
            b *= 2;
            cnt++;
        }
        while (b >= c) {
            c *= 2;
            cnt++;
        }
        out.ans(cnt <= k).ln();
    }
}
