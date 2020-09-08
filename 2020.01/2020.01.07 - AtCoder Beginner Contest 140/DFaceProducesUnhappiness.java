package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DFaceProducesUnhappiness {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints(), ans = 0;
        char[] s = in.string().toCharArray();
        for (int i = 0; i < n - 1; i++) if (s[i] == s[i + 1]) ans++;
        out.ans(Math.min(n - 1, ans + 2 * k)).ln();
    }
}
