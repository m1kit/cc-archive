package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CHAndV {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int h = in.ints(), w = in.ints(), k = in.ints();
        char[][] s = in.chars(h);
        int ans = 0;
        for (int i = 0; i < (1 << h); i++) {
            for (int j = 0; j < (1 << w); j++) {
                int count = 0;
                for (int l = 0; l < h; l++) {
                    for (int m = 0; m < w; m++) {
                        if ((i & (1 << l)) == 0 && (j & (1 << m)) == 0 && s[l][m] == '#') count++;
                    }
                }
                if (count == k) ans++;
            }
        }
        out.ans(ans).ln();
    }
}
