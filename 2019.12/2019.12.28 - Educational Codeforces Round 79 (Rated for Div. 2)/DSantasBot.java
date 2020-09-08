package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class DSantasBot {

    private static final int MOD = 998244353;
    private static final int MAX = 1_000_000;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        ModMath mod = new ModMath(MOD);
        int n = in.ints(), ninv = (int) mod.inv(n);
        long[] p = new long[MAX], c = new long[MAX];
        for (int i = 0; i < n; i++) {
            int k = in.ints(), kinv = (int) mod.inv(k);
            for (int j = 0; j < k; j++) {
                int item = in.ints() - 1;
                c[item]++;
                p[item] = (p[item] + kinv) % MOD;
            }
        }
        for (int i = 0; i < MAX; i++) {
            p[i] *= ninv;
            p[i] %= MOD;
        }
        long ans = 0;
        for (int i = 0; i < MAX; i++) {
            ans += c[i] * ninv % MOD * p[i] % MOD;
            ans %= MOD;
        }
        out.ans(ans).ln();
    }
}
