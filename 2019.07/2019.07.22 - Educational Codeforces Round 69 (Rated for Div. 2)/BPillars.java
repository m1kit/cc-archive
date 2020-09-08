package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BPillars {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        boolean[] left = new boolean[n], right = new boolean[n];
        left[0] = right[n - 1] = true;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] && a[i - 1] < a[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] && a[i] > a[i + 1];
        }
        boolean ans = false;
        for (int i = 0; i < n; i++) {
            ans |= left[i] && right[i];
        }
        out.ans(ans).ln();
    }
}
