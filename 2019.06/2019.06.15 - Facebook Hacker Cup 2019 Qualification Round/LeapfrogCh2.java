package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class LeapfrogCh2 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.Y_N_ALL_UP);
        out.ans("Case #" + testNumber + ":");
        String s = in.string();
        long n = s.length();
        long b = s.chars().filter(c -> c == 'B').count();
        if (b == 0 || b == n - 1) {
            out.noln();
            return;
        } else if (b >= 2) {
            out.yesln();
            return;
        }
        out.ans(n == 3).ln();
    }
}
