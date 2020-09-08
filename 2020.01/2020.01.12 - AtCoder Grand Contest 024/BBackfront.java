package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.seqence.LIS;

import java.util.Arrays;

public class BBackfront {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), ans = 1;
        int[] rev = new int[n];
        for (int i = 0; i < n; i++) rev[in.ints() - 1] = i;

        int len = 1;
        for (int i = 1; i < n; i++) {
            if (rev[i - 1] < rev[i]) ans = Math.max(ans, ++len);
            else len = 1;
        }
        out.ans(n - ans).ln();
    }
}
