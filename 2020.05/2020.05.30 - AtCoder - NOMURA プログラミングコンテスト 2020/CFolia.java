package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.math.BigInteger;

public class CFolia {

    private static final long INF = Long.MAX_VALUE / 2;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n + 1);
        long ans = 0, now = 1;
        long[] max = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            max[i] = now;
            if (now < a[i]) {
                out.ans(-1).ln();
                return;
            }
            now -= a[i];
            if (now >= INF) now = Long.MAX_VALUE;
            else now <<= 1;
        }
        long inc = 0;
        for (int i = n; i >= 0; i--) {
            long d = Math.min(max[i], inc + a[i]);
            ans += d;
            inc = d;
        }
        out.ans(ans).ln();
    }
}
