package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class CGCDOnBlackboard {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n);
        long[] left = new long[n], right = new long[n];
        left[0] = a[0];
        right[n - 1] = a[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = IntMath.gcd(left[i - 1], a[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = IntMath.gcd(right[i + 1], a[i]);
        }
        long ans = Math.max(right[1], left[n - 2]);
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, IntMath.gcd(left[i - 1], right[i + 1]));
        }
        out.ans(ans).ln();
    }
}
