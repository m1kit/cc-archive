package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CRemainderMinimization2019 {

    private static final int MOD = 2019;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long l = in.longs(), r = in.longs();
        if (l == 0 || r - l + 1 >= 2019) {
            out.ans(0).ln();
            return;
        }
        long ans = 2018;
        for (long i = l; i <= r; i++) {
            for (long j = i + 1; j <= r; j++) {
                ans = Math.min(ans, ((i % MOD) * (j % MOD)) % MOD);
            }
        }
        out.ans(ans).ln();
    }
}
