package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CSubarraySum {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints(), s = in.ints();
        int t = s == 1_000_000_000 ? 999_999_999 : 1_000_000_000;
        for (int i = 0; i < k; i++) {
            out.ans(s);
        }
        for (int i = 0; i < n - k; i++) {
            out.ans(t);
        }
        out.ln();
    }
}
