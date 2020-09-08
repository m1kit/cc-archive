package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long m = in.longs();
        int v = in.ints(), p = in.ints();

        long[] a = in.longs(n);
        IntroSort.sort(a);
        long[] sum = IntMath.sum(a);

        int ans = p;
        for (int i = 0; i < n - p; i++) {
            if (a[i] + m < a[n - p]) continue;

            long rem = m * (v - p);
            rem -= (n - p - i) * (a[i] + m) - (sum[n - p + 1] - sum[i + 1]);
            rem -= i * m;
            if (rem <= 0) ans++;
        }
        out.ans(ans).ln();
    }
}
