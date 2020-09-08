package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class BColorfulCreatures {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);

        IntroSort.sort(a);
        long siz = a[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (siz * 2 < a[i]) {
                ans = i;
            }
            siz += a[i];
        }
        out.ansln(n - ans);
    }
}
