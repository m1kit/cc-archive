package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BTouitsu {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String[] a = in.string(3);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[0].charAt(i) == a[1].charAt(i) && a[1].charAt(i) == a[2].charAt(i)) {
                continue;
            } else if (a[0].charAt(i) == a[1].charAt(i) || a[1].charAt(i) == a[2].charAt(i) || a[2].charAt(i) == a[0].charAt(i)) {
                ans++;
            } else {
                ans+=2;
            }
        }
        out.ansln(ans);
    }
}
