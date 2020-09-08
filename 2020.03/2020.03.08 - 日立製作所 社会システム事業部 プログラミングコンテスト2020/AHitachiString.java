package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AHitachiString {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {

        char[] s = in.chars();
        int n = s.length;
        if (n % 2 == 1) {
            out.noln();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && s[i] != 'h') {
                out.noln();
                return;
            }
            if (i % 2 == 1 && s[i] != 'i') {
                out.noln();
                return;
            }
        }
        out.yesln();

    }
}
