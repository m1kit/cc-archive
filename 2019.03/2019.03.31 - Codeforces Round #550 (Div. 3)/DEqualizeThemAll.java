package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DEqualizeThemAll {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        int[] cnt = new int[200_001];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, ++cnt[a[i]]);
        }
        int maxval = -1;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max) {
                maxval = i;
            }
        }

        out.ansln(n - max);
        boolean f = false;
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == maxval) {
                f = true;
            } else if (f) {
                out.ans(maxval > a[i] ? 1 : 2).ans(i + 1).ans(i).ln();
            } else {
                m = i;
            }
        }
        for (; m >= 0; m--) {
            if (a[m] != maxval) {
                out.ans(maxval > a[m] ? 1 : 2).ans(m + 1).ans(m + 2).ln();
            }
        }
    }
}
