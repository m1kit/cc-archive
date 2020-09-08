package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ACountTriplets {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = 0;
            for (int j = 0; j < i; j++) if (a[j] < a[i]) l++;
            for (int j = i + 1; j < n;j++) if (a[j] < a[i]) r++;
            ans += l * r;
        }
        out.ans(ans).ln();
    }
}
