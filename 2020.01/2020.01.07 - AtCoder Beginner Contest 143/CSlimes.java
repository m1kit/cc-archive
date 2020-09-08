package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CSlimes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), ans = 1;
        char[] s = in.string().toCharArray();
        for (int i = 1; i < n; i++) if (s[i - 1] != s[i]) ans++;
        out.ans(ans).ln();
    }
}
