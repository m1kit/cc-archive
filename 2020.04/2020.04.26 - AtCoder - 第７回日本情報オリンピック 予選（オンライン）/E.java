package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.Interactor;
import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.BitMath;

public class E {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        int[] a = new int[m];
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) a[j] |= in.ints() << i;
        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            int res = 0;
            for (int j = 0; j < m; j++) {
                int t = Integer.bitCount(a[j] ^ i);
                res += Math.max(t, n - t);
            }
            ans = Math.max(ans, res);
        }
        out.ans(ans).ln();
    }
}
