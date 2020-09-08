package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CMaximalValue {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), ans = 0;
        int[] b = new int[n + 1];
        b[0] = b[n] = 100_000;
        for (int i = 1; i < n; i++) b[i] = in.ints();
        for (int i = 0; i < n; i++) ans += Math.min(b[i], b[i + 1]);
        out.ans(ans).ln();
    }
}
