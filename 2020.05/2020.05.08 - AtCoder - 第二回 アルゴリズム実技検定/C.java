package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int h = in.ints();
        char[][] s = in.chars(h);
        for (int i = h - 2; i >= 0; i--) {
            for (int j = 1; j < 2 * h - 2; j++) {
                if (s[i][j] == '#' && (s[i + 1][j - 1] == 'X'||s[i + 1][j] == 'X'||s[i + 1][j + 1] == 'X')) s[i][j] = 'X';
            }
        }
        for (int i = 0; i < h; i++) out.print(String.valueOf(s[i])).ln();
    }
}
