package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CDigitsInMultiplication {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long n = in.longs();
        int ans = 100;
        for (long i = 1; i * i <= n; i++) {
            if (n % i > 0) continue;
            long j = n / i;
            int c = 0;
            while (j > 0) {
                j /= 10;
                c++;
            }
            ans = Math.min(ans, c);
        }
        out.ansln(ans);
    }
}
