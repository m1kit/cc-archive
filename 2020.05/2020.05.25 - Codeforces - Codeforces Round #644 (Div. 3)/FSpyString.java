package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class FSpyString {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        loop: for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints(), m = in.ints();
            char[][] s = in.chars(n);
            char[] t = s[0].clone();
            for (int i = 0; i < m; i++) {
                mid: for (char c = 'a'; c <= 'z'; c++) {
                    t[i] = c;
                    for (int j = 1; j < n; j++) {
                        int d = 0;
                        for (int k = 0; k < m; k++) if (s[j][k] != t[k]) d++;
                        if (d > 1) {
                            t[i] = s[0][i];
                            continue mid;
                        }
                    }
                    out.ans(String.valueOf(t)).ln();
                    continue loop;
                }
            }
            out.ans(-1).ln();
        }
    }
}
