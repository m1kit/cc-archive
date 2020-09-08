package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CNextLetter {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        char[] s = in.string().toCharArray();
        int n = s.length, k = in.ints();
        System.out.println("0x" + Integer.toBinaryString(0xEA ^ 0x30));
        System.out.println(0x44);
        System.out.println(0x34);
        System.out.println(103 ^ 68);
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') continue;
            int r = 'z' - s[i] + 1;
            if (k >= r) {
                k -= r;
                s[i] = 'a';
            }
        }
        k %= 26;
        while (k-- > 0) s[n - 1]++;
        out.ans(String.valueOf(s)).ln();
    }
}
