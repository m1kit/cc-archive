package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DWalkAndTeleport {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long a = in.longs(), b = in.longs();
        int[] x = in.ints(n);
        long ans = 0;
        for (int i = 1; i < n; i++) ans += Math.min(b, a * (x[i] - x[i - 1]));
        out.ans(ans).ln();
    }
}
