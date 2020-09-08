package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class EDividingChocolate {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int h = in.ints(), w = in.ints(), k = in.ints();
        char[][] s = in.chars(h);
        int ans = h + w - 2, all = 1 << (h - 1);
        int[] dest = new int[h], count = new int[h];
        outer:
        for (int i = 0; i < all; i++) {
            int res = 0;
            count[0] = 0;
            for (int j = 0; j < h - 1; j++) {
                dest[j + 1] = dest[j];
                if (((i >> j) & 1) == 1) {
                    count[++dest[j + 1]] = 0;
                    res++;
                }
            }
            for (int j = 0; j < w; j++) {
                boolean ok = true;
                for (int l = 0; l < h; l++) {
                    if (s[l][j] == '0') continue;
                    if (k < ++count[dest[l]]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) continue;
                res++;
                for (int l = 0; l <= dest[h - 1]; l++) count[l] = 0;
                for (int l = 0; l < h; l++) {
                    if (s[l][j] == '0') continue;
                    if (k < ++count[dest[l]]) continue outer;
                }
            }
            ans = Math.min(ans, res);
        }
        out.ans(ans).ln();
    }
}
