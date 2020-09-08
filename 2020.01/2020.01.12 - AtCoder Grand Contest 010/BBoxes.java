package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class BBoxes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints();
        long sum = 0, op = n * (n + 1L) / 2;
        long[] a = in.longs(n);
        for (int i = 0; i < n; i++) sum += a[i];
        if (sum % op != 0) {
            out.noln();
            return;
        }

        long k = sum / op;
        long[] d = new long[n];
        for (int i = 0; i < n; i++) d[i] = a[i] - a[(i + 1) % n] + k;
        for (int i = 0; i < n; i++) {
            if (d[i] < 0 || d[i] % n != 0) {
                out.noln();
                return;
            }
        }
        out.yesln();
    }
}
