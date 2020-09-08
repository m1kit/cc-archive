package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BFindSymmetries {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), ans = 0;
        char[][] s = in.chars(n);
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < j; k++) {
                    if (s[(j + i) % n][k] != s[(k + i) % n][j]) continue outer;
                }
            }
            ans += n;
        }
        out.ans(ans).ln();
    }
}
