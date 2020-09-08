package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String[] s = in.string(n);
        int r = 0, b = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i].charAt(j) == 'R') {
                    r++;
                } else if (s[i].charAt(j) == 'B') {
                    b++;
                }
            }
        }
        if (r == b) {
            out.ans("DRAW").ln();
        } else if (r < b) {
            out.ans("AOKI").ln();
        } else {
            out.ans("TAKAHASHI").ln();
        }
    }
}
