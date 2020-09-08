package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] max = new int[3];
        for (int i = 0; i < n; i++) {
            int[] a = in.ints(3);
            Arrays.sort(a);
            for (int j = 0; j < 3; j++) max[j] = Math.max(max[j], a[j]);
        }
        out.ans(max[0] * max[1] * max[2]).ln();
    }
}
