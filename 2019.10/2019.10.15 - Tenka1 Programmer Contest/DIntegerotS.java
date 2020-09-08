package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.BitMath;

public class DIntegerotS {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        long ans = 0;
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ints();
            b[i] = in.ints();
            if ((a[i] | k) == k) ans += b[i];
        }
        for (int i = 0; i < 30; i++) {
            int rem = 1 << i;
            if ((k & rem) == 0) continue;
            int mask = (k & ~rem) | (rem - 1);
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if ((a[j] | mask) == mask) sum += b[j];
            }
            ans = Math.max(ans, sum);
        }
        out.ans(ans).ln();
    }
}
