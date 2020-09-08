package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;

import java.util.Arrays;

public class BSubstring {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        char[] s = in.chars(), t = in.chars();
        int n = s.length, m = t.length, ans = Integer.MAX_VALUE;
        //System.out.println(Arrays.toString(s));
        //System.out.println(Arrays.toString(t));
        for (int i = 0; i <= n - m; i++) {
            int d = 0;
            for (int j = 0; j < m; j++) {
                if (s[i + j] != t[j]) d++;
            }
            //System.out.println(i + "+" + d);
            ans = Math.min(ans, d);
        }
        out.ans(ans).ln();
    }
}
