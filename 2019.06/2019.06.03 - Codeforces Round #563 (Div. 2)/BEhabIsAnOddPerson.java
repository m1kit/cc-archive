package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;

public class BEhabIsAnOddPerson {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        boolean[] flag = new boolean[2];
        for (int i = 0; i < n; i++) {
            flag[a[i] % 2] = true;
        }
        if (flag[0] && flag[1]) {
            Arrays.sort(a);
        }
        out.ans(a).ln();
    }
}
