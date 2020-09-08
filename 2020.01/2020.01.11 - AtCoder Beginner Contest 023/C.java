package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.FFT;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int r = in.ints(), c = in.ints(), k = in.ints(), n = in.ints();
        int[] rc = new int[r], cc = new int[c];
        int[] x = new int[n], y = new int[n];
        for (int i = 0; i < n; i++) {
            rc[x[i] = in.ints() - 1]++;
            cc[y[i] = in.ints() - 1]++;
        }
        if (k > n) {
            out.ans(0).ln();
            return;
        }

        long[] ccnt = new long[n + 1];
        for (int i = 0; i < c; i++) ccnt[cc[i]]++;

        long ans = 0;
        for (int i = 0; i < r; i++) {
            if (rc[i] > k) continue;
            ans += ccnt[k - rc[i]];
        }

        for (int i = 0; i < n; i++) {
            int total = rc[x[i]] + cc[y[i]];
            if (total == k) ans--;
            else if (total == k + 1) ans++;
        }
        out.ans(ans).ln();
    }
}
