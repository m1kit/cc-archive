package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class BStringPalindrome {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        String s = in.string();
        char[] c = s.toCharArray();
        int n = c.length;
        ArrayUtil.reverse(c, 0, n / 2);
        ArrayUtil.reverse(c, (n + 1) / 2, n);
        out.ans(s.equals(String.valueOf(c)) && new StringBuilder(s).reverse().toString().equals(s)).ln();
    }
}
