package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B2525 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int ans = 0;
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '2') {
                depth++;
                ans = Math.max(ans, depth);
            } else {
                depth--;
                if (depth < 0) {
                    out.ansln(-1);
                    return;
                }
            }
        }
        if (depth != 0) {
            out.ansln(-1);
            return;
        }
        out.ansln(ans);
    }
}
