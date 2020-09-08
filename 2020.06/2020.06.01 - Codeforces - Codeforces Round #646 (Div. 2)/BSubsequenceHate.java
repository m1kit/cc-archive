package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BSubsequenceHate {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            char[] s = in.chars();
            int n = s.length;
            int[][] l = new int[2][n + 1], r = new int[2][n + 1];
            for (int i = 0; i < n; i++) {
                l[0][i + 1] = l[0][i];
                l[1][i + 1] = l[1][i];
                l[s[i] % 2][i + 1] += 1;
            }
            for (int i = n - 1; i >= 0; i--) {
                r[0][i] = r[0][i + 1];
                r[1][i] = r[1][i + 1];
                r[s[i] % 2][i] += 1;
            }
            int ans = n;
            for (int i = 0; i <= n; i++) {
                ans = Math.min(ans, l[0][i] + r[1][i]);
                ans = Math.min(ans, l[1][i] + r[0][i]);
            }
            out.ans(ans).ln();
        }
    }
}
