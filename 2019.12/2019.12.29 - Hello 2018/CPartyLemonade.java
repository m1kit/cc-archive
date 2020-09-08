package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class CPartyLemonade {

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long l = in.longs();
        long[] a = new long[32];
        Arrays.fill(a, Long.MAX_VALUE);
        for (int i = 0; i < n; i++) a[i] = in.longs();
        for (int i = n - 2; i >= 0; i--) a[i] = Math.min(a[i], a[i + 1]);

        for (int i = 1; i < 32; i++) {
            if (a[i - 1] < Long.MAX_VALUE / 2)
                a[i] = Math.min(a[i], a[i - 1] * 2);
        }
        //System.out.println(Arrays.toString(a));

        long ans = Long.MAX_VALUE, t = 0;
        for (int i = 31; i >= 0; i--) {
            long b = (1L << i);

            if ((l & b) != 0) t += a[i];
            else if (a[i] < Long.MAX_VALUE - t) ans = Math.min(ans, t + a[i]);
        }
        out.ans(Math.min(ans, t)).ln();
    }
}
