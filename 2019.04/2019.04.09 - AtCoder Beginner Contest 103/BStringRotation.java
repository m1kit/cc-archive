package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BStringRotation {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string(), t = in.string();
        for (int i = 0; i <= 100; i++) {
            if (s.equals(t)) {
                out.yesln();
                return;
            }
            s = s.substring(1) + s.charAt(0);
        }
        out.noln();
    }
}
