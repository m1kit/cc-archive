package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int l = in.ints(), r = in.ints();
        int[] x = in.ints(l), y = in.ints(r);
        IntroSort.sort(x);
        IntroSort.sort(y);
        int c = 0;
        int ans = 0;
        for (int d = 0; d < r; d++) {
            while (c < l && x[c] < y[d]) {
                c++;
            }
            if (c < l && x[c] == y[d]) {
                ans++;
                c++;
            }
        }
        out.ans(ans).ln();
    }
}
