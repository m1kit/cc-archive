package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CAtCoDeerAtCoDeerAndElectionReport {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long x = 1, y = 1;
        for (int i = 0; i < n; i++) {
            int a = in.ints(), b = in.ints();
            while (x % a > 0) x++;
            while (y % b > 0) y++;
            if (x / a * b > y) {
                y = x / a * b;
            } else if (y / b * a > x) {
                x = y / b * a;
            }
        }
        out.ans(x + y).ln();
    }
}
