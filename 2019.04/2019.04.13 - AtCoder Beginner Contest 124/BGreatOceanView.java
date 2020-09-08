package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BGreatOceanView {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] h = in.ints(n);
        int max = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (max <= h[i]) {
                ans++;
            }
            max = Math.max(max, h[i]);
        }
        out.ansln(ans);
    }
}
