package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class BCountingOfTrees {

    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] cnt = new long[n];
        int max = 0;
        if (in.ints() != 0) {
            out.ans(0).ln();
            return;
        }
        cnt[0] = 1;
        for (int i = 1; i < n; i++) {
            int d = in.ints();
            if (d == 0) {
                out.ans(0).ln();
                return;
            }
            max = Math.max(max, d);
            cnt[d]++;
        }
        ModMath mod = new ModMath(MOD);
        long ans = 1;
        for (int i = 1; i <= max; i++) {
            long comb = mod.pow(cnt[i - 1], cnt[i]);
            ans *= comb;
            ans %= MOD;
        }
        out.ans(ans).ln();
    }
}
