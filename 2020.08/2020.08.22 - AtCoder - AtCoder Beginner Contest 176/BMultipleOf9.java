package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BMultipleOf9 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int sum = 0;
        for (char c : in.chars()) {
            sum += c - '0';
        }
        out.ans(sum % 9 == 0).ln();
    }
}
