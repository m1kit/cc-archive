package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        char[] s = in.string().toCharArray();
        int n = s.length, d = 0;
        {
            int l = 0, r = n - 1;
            while (l < r) {
                if (s[l] != s[r]) d++;
                l++;
                r--;
            }
        }
        if (d == 0) {
            out.ans(n / 2 * 2 * 25).ln();
        } else if (d == 1) {
            out.ans(n * 25 - 2).ln();
        } else {
            out.ans(n * 25).ln();
        }
    }
}
