package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DDuplicated {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] count = new int[n];
        for (int i = 0; i < n; i++) count[in.ints() - 1]++;
        int from = -1, dest = -1;
        for (int i = 0; i < n; i++) {
            if (count[i] == 0) dest = i + 1;
            else if (count[i] == 2) from = i + 1;
        }
        if (from == -1) out.ans("Correct").ln();
        else out.ans(from).ans(dest).ln();
    }
}
