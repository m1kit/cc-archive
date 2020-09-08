package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class F {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        char[][] s = in.chars(n);
        char[] ans = new char[n];
        loop: for (int i = 0; i * 2 < n; i++) {
            int j = n - i - 1;
            for (char c = 'a'; c <= 'z'; c++) {
                int f = 0;
                for (int k = 0; k < n && f != 3; k++) {
                    if (s[i][k] == c) f |= 1;
                    if (s[j][k] == c) f |= 2;
                }
                if (f == 3) {
                    ans[i] = ans[j] = c;
                    continue loop;
                }
            }
            out.ans(-1).ln();
            return;
        }
        out.ans(String.valueOf(ans)).ln();
    }
}
