package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class DAlterAltar {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        char[] s = in.chars();
        int ans = 0;
        int lcur = 0, rcur = n - 1;
        while (lcur < rcur) {
            while (lcur < rcur && s[lcur] != 'W') lcur++;
            while (lcur < rcur && s[rcur] != 'R') rcur--;
            if (s[lcur] == 'W' && s[rcur] == 'R') {
                ans++;
                lcur++;
                rcur--;
            }
        }
        out.ans(ans).ln();
    }
}
