package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DUnbalanced {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                out.ans(i + 1).ans(i + 2).ln();
                return;
            }
        }
        for (int i = 0; i < n - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 2)) {
                out.ans(i + 1).ans(i + 3).ln();
                return;
            }
        }
        out.ans(-1).ans(-1).ln();
    }
}
