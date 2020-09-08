package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DDiceInLine {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        double[] s = new double[n + 1];
        for (int i = 0; i < n; i++) {
            int p = in.ints();
            s[i + 1] = s[i] + (1 + p) * p * 0.5 / p;
        }
        double ans = 0;
        for (int i = 0; i <= n - k; i++) {
            ans = Math.max(ans, s[i + k] - s[i]);
        }
        out.ans(ans, 12).ln();
    }
}
