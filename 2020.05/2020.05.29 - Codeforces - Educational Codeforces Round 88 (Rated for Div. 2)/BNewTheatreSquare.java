package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BNewTheatreSquare {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints(), m = in.ints(), x = in.ints(), y = in.ints();
            y = Math.min(y, x * 2);
            long ans = 0;
            for (int i = 0; i < n; i++) {
                char[] s = in.chars();
                for (int j = 0; j < m; j++) {
                    if (s[j] == '*') continue;
                    if (j == m - 1 || s[j + 1] == '*') ans += x;
                    else {
                        ans += y;
                        j++;
                    }
                }
            }
            out.ans(ans).ln();
        }
    }
}
