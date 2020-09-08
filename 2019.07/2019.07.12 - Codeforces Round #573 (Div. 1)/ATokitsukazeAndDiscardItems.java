package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ATokitsukazeAndDiscardItems {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long n = in.longs();
        int m = in.ints();
        long k = in.longs();
        long[] p = new long[m];
        for (int i = 0; i < m; i++) p[i] = in.longs() - 1;
        int ans = 1, delta = 1;
        long lpr = p[0] / k;
        for (int i = 1; i < m; i++) {
            long pageBefore = (p[i] - i + delta) / k;
            if (pageBefore != lpr) {
                ans++;
                delta = 1;
            } else {
                delta++;
            }
            lpr = (p[i] - i) / k;
        }
        out.ans(ans).ln();
    }
}
