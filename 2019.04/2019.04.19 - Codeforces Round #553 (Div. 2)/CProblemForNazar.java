package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CProblemForNazar {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long l = in.longs(), r = in.longs();
        out.ansln((ans(r) - ans(l - 1) + MOD) % MOD);
    }

    private static long ans(long r) {
        long even = 0, odd = 0;
        long t = r;
        for (int i = 1; i <= 60; i++) {
            long v = (1L << i) - 1;
            if (v > r) {
                if (i % 2 == 1) {
                    odd += t;
                } else {
                    even += t;
                }
                break;
            }
            long c = (1L << (i - 1));
            t -= c;
            c %= MOD;

            if (i % 2 == 1) {
                odd += c;
            } else {
                even += c;
            }
            even %= MOD;
            odd %= MOD;
        }
        even %= MOD;
        odd %= MOD;
        long ans = 0;
        ans += (even + 1L) * even % MOD;
        ans += odd * odd % MOD;
        ans %= MOD;
        return ans;
    }
}
