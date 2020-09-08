package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class LongestArithmetic {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        int ans = 2;
        for (int i = 0; i < n - 1; i++) {
            int d = a[i + 1] - a[i];
            int now = i + 1;
            while (now < n - 1 && a[now + 1] - a[now] == d) {
                now++;
                ans = Math.max(ans, now - i + 1);
            }
            i = Math.max(i, now - 1);
        }
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        out.cases(testNumber).ans(ans).ln();
    }
}
