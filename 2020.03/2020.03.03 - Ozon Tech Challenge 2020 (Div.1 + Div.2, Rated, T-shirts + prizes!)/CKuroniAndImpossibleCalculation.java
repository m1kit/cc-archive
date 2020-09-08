package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CKuroniAndImpossibleCalculation {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        long[] a = in.longs(n);
        int[] cnt = new int[m];
        for (int i = 0; i < n; i++) {
            if (++cnt[(int) (a[i] % m)] > 1) {
                out.ans(0).ln();
                return;
            }
        }
        long ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                ans *= Math.abs(a[i] - a[j]);
                ans %= m;
            }
        }
        out.ans(ans).ln();
    }
}
