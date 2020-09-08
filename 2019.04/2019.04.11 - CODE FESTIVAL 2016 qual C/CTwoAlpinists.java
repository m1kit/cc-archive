package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CTwoAlpinists {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n), b = in.longs(n);
        long[] spec = new long[n];
        long t = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > t) {
                spec[i] = a[i];
                t = a[i];
                if (b[i] < a[i]) {
                    //System.out.println("A:"+i);
                    out.ansln(0);
                    return;
                }
            }
        }
        t = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (b[i] > t) {
                if (spec[i] > 0 && spec[i] != b[i]) {
                    out.ansln(0);
                    return;
                }
                if (a[i] < b[i]) {
                    //System.out.println("B:"+i);
                    out.ansln(0);
                    return;
                }
                spec[i] = b[i];
                t = b[i];
            }
        }

        long ans = 1;
        for (int i = 0; i < n; i++) {
            if (spec[i] > 0) {
                continue;
            }
            ans *= Math.min(a[i], b[i]);
            ans %= MOD;
        }
        out.ansln(ans);
    }
}
