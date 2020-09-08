package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ALoveA {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String a = in.string();
        int c = a.length();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != 'a') c--;
        }
        out.ans(a.length() - Math.max(0, a.length() - 2 * c + 1)).ln();
    }
}
