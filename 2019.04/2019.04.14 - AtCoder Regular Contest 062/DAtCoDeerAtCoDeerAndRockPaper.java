package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DAtCoDeerAtCoDeerAndRockPaper {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int ans = 0, g = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'g') {
                if (g > 0) {
                    ans++;
                    g--;
                } else {
                    g++;
                }
            } else {
                if (g > 0) {
                    g--;
                } else {
                    ans--;
                    g++;
                }
            }
        }
        out.ansln(ans);
    }
}
