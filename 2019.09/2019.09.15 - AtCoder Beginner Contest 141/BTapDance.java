package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BTapDance {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        char[] s = in.string().toCharArray();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && s[i] == 'L') {
                out.noln();
                return;
            } else if (i % 2 == 1 && s[i] == 'R') {
                out.noln();
                return;
            }
        }
        out.yesln();
    }
}
