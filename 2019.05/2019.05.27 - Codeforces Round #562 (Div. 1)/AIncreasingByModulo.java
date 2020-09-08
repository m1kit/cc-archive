package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AIncreasingByModulo {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int[] a = in.ints(n);
        int min = -1, max = m - 1;
        bisearch: while (max - min > 1) {
            int mid = (min + max + 1) / 2;
            int last = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] + mid < last) {
                    min = mid;
                    continue bisearch;
                } else if (a[i] > last && a[i] + mid - m < last) {
                    last = a[i];
                }
            }
            max = mid;
        }
        out.ans(max).ln();
    }
}
