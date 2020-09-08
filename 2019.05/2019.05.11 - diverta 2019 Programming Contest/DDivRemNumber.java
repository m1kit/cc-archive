package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DDivRemNumber {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long n = in.longs(), ans = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i != 0) continue;
            long a = i, b = n / i;
            //System.out.println("m="+(a-1));
            //System.out.println("m="+(b-1));
            if (b < a - 1)
            ans += a - 1;
            if (a < b - 1)
            ans += b - 1;
        }
        out.ans(ans).ln();
    }
}
