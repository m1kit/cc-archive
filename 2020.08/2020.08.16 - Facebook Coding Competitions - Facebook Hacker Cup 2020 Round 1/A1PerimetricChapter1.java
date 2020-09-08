package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class A1PerimetricChapter1 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        int n = in.ints(), pk = in.ints(), w = in.ints();
        long[] l = new long[n], h = new long[n];
        for (int i = 0; i < pk; i++) l[i] = in.longs();
        long[] pa = in.longs(4);
        for (int i = pk; i < n; i++) l[i] = (pa[0] * l[i - 2] + pa[1] * l[i - 1] + pa[2]) % pa[3] + 1;
        for (int i = 0; i < pk; i++) h[i] = in.longs();
        long[] pb = in.longs(4);
        for (int i = pk; i < n; i++) h[i] = (pb[0] * h[i - 2] + pb[1] * h[i - 1] + pb[2]) % pb[3] + 1;
        long[] p = new long[n];
        long prod = 1, now = 0;
        for (int i = 0; i < n; i++) {
            now += 2 * w + 2 * h[i];
            if (0 < i && l[i] <= l[i - 1] + w) {
                long high = h[i - 1];
                for (int j = i - 2; 0 <= j && l[i] - w <= l[j]; j--) {
                    high = Math.max(high, h[j]);
                }
                now -= 2 * Math.min(high, h[i]);
                now -= 2 * (w + l[i - 1] - l[i]);
            }
            p[i] = now;
            prod *= now % MOD;
            prod %= MOD;
        }
        //*
        //System.out.println("L: " + Arrays.toString(l));
        //System.out.println("H: " + Arrays.toString(h));
        //System.out.println("P: " + Arrays.toString(p));
        //*/
        out.cases(testNumber).ans(prod).ln();
    }
}
