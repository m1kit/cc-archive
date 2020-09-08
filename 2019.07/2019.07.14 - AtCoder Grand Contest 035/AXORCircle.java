package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AXORCircle {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        IntroSort.sort(a);
        if (n % 3 != 0) {
            out.ans(a[n - 1] == 0).ln();
        } else if (a[0] != a[n / 3 - 1] || a[n / 3] != a[n / 3 * 2 - 1] || a[n / 3 * 2] != a[n - 1]) {
            out.noln();
        } else {
            out.ans((a[0] ^ a[n / 3] ^ a[n - 1]) == 0).ln();
        }
    }
}
