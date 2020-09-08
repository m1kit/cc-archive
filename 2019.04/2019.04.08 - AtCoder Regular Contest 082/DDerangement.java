package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DDerangement {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] p = in.ints(n);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] == i + 1) {
                ans++;
                i++;
            }
        }
        out.ansln(ans);
    }
}
