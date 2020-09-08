package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), max = 0;
        int[] a = in.ints(n), cnt = new int[n];
        ModMath mod = new ModMath();
        long ans = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
            cnt[a[i]]++;
        }
        if (a[0] != 0 || cnt[0] > 1) ans = 0;
        for (int i = 1; i < n; i++) {
            ans *= mod.pow(2, cnt[i] * (cnt[i] - 1L) / 2);
            ans %= MOD;
            ans *= mod.pow(mod.pow(2, cnt[i - 1]) - 1, cnt[i]);
            ans %= MOD;
        }
        out.ans(ans).ln();
    }
}
