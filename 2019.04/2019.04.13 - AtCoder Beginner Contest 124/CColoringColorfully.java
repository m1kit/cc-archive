package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CColoringColorfully {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') == (i % 2)) {
                ans++;
            }
        }
        out.ansln(Math.min(ans, s.length() - ans));
    }
}
