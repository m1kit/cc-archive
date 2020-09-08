package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AFallingAsleep {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        String[] s = new String[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.string();
            t[i] = in.ints();
        }
        int ans = 0;
        String x = in.string();
        boolean ok = false;
        for (int i = 0; i < n; i++) {
            if (ok) ans += t[i];
            if (x.equals(s[i])) ok = true;
        }
        out.ans(ans).ln();
    }
}
