package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class YouCanGoYourOwnWay {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        String t = in.string();
        out.print("Case #" + testNumber + ": ");
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == 'S') {
                out.print('E');
            } else {
                out.print('S');
            }
        }
        out.ln();
    }
}
