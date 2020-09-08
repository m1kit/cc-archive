package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class CMultipleClocks {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long ans = 1;
        long[] a = in.longs(n);
        for (int i = 0; i < n; i++) {
            ans = IntMath.lcm(ans, a[i]);
        }
        out.ansln(ans);
    }
}
