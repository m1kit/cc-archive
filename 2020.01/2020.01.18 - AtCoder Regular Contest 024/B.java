package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        if (IntMath.max(a) == IntMath.min(a)) {
            out.ans(-1).ln();
            return;
        }
        int offset = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) offset = i + 1;
        }
        int ans = 0, len = 1;
        for (int i = 1; i < n; i++) {
            if (a[(offset + i - 1) % n] == a[(offset + i) % n]) ans = Math.max(ans, ++len);
            else len = 1;
        }
        out.ans((ans + 1) / 2).ln();
    }
}
