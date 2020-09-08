package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BWOWFactor {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int n = s.length();
        int v = 0;
        int w = 0;
        int[] left = new int[n], right = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'v') v++;
            else {
                w += Math.max(0, v - 1);
                v = 0;
                left[i] = w;
            }
        }
        v = w = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'v') v++;
            else {
                w += Math.max(0, v - 1);
                v = 0;
                right[i] = w;
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'o') {
                ans += left[i] * (long) right[i];
            }
        }
        out.ans(ans).ln();
    }
}
