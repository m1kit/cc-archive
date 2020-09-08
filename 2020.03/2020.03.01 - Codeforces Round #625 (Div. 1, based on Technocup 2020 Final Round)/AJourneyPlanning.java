package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class AJourneyPlanning {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] b = in.ints(n);
        long[] c = new long[1_000_000];
        for (int i = 0; i < n; i++) c[b[i] - i + 500_000] += b[i];
        long ans = 0;
        for (int i = 0; i < 1_000_000; i++) {
            ans = Math.max(ans, c[i]);
        }
        out.ans(ans).ln();
    }
}
