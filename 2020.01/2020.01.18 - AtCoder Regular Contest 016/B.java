package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), ans = 0;
        char[][] s = new char[n + 1][];
        s[0] = ".........".toCharArray();
        for (int i = 1; i <= n; i++) s[i] = in.string().toCharArray();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 9; j++) {
                if (s[i][j] == 'x') ans++;
                if (s[i][j] == 'o' && s[i - 1][j] != 'o') ans++;
            }
        }
        out.ans(ans).ln();
    }
}
