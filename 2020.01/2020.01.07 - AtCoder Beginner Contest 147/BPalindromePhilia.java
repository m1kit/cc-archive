package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BPalindromePhilia {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        char[] s = in.string().toCharArray();
        int ans = 0, lo = 0, hi = s.length - 1;
        while (lo < hi) {
            if (s[lo++] != s[hi--]) ans++;
        }
        out.ans(ans).ln();
    }
}
