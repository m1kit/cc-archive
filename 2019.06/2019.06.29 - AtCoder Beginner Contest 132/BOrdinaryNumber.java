package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class BOrdinaryNumber {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), ans = 0;
        int[] p = in.ints(n);
        for (int i = 1; i < n - 1; i++) {
            if (IntMath.min(p[i - 1], p[i], p[i + 1]) < p[i] && p[i] < IntMath.max(p[i - 1], p[i], p[i + 1])) ans++;
        }
        out.ans(ans).ln();
    }
}
