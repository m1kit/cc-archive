package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CSequence {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n);
        long ans = Long.MAX_VALUE;

        {
            long sum = 0;
            long t = 0;
            for (int i = 0; i < n; i++) {
                if (sum < 0) {
                    sum += a[i];
                    if (sum <= 0) {
                        t += 1 - sum;
                        sum = 1;
                    }
                } else {
                    sum += a[i];
                    if (sum >= 0) {
                        t += 1 + sum;
                        sum = -1;
                    }
                }
            }
            ans = Math.min(ans, t);
        }
        {
            long sum = 0;
            long t = 0;
            for (int i = 0; i < n; i++) {
                if (sum <= 0) {
                    sum += a[i];
                    if (sum <= 0) {
                        t += 1 - sum;
                        sum = 1;
                    }
                } else {
                    sum += a[i];
                    if (sum >= 0) {
                        t += 1 + sum;
                        sum = -1;
                    }
                }
            }
            ans = Math.min(ans, t);
        }
        out.ansln(ans);
    }
}
