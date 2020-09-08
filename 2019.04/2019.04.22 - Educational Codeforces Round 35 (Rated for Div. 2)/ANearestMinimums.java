package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class ANearestMinimums {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int min = IntMath.min(a);
        int last = -1000000;
        int ans = 100000000;
        for (int i = 0; i < n; i++) {
            if (a[i] == min) {
                ans = Math.min(i - last, ans);
                last = i;
            }
        }
        out.ans(ans).ln();
    }
}
