package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        int[] a = in.ints(n), s = new int[n];
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1];
            if (a[i - 1] >= a[i]) s[i]++;
        }
        int ans = 0;
        for (int i = 0; i <= n - k; i++) {
            if (s[i + k - 1] - s[i] == 0) ans++;
        }
        out.ans(ans).ln();
    }
}
