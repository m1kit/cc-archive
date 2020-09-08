package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BMinorChange {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        char[] s = in.chars(), t = in.chars();
        int n = s.length, ans = 0;
        for (int i = 0; i < n; i++) if (s[i] != t[i]) ans++;
        out.ans(ans).ln();
    }
}
