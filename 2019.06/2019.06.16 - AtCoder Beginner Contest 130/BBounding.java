package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BBounding {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), x = in.ints();
        int[] l = in.ints(n);
        int count = 1;
        int pos = 0;
        for (int i = 0; i < n; i++) {
            pos += l[i];
            if (pos <= x) count++;
        }
        out.ans(count).ln();
    }
}
