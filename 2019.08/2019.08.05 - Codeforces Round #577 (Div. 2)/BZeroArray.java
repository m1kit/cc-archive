package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BZeroArray {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (a[i] * 2 > sum) {
                flag = false;
            }
        }
        out.ans(flag && sum % 2 == 0).ln();
    }
}
