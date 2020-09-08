package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class No1206OROROR {

    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        // N(2^NK - 2^K(N-1))
        ModMath mod = new ModMath(MOD);
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            long n = in.longs(), k = in.longs();
            long ans = MOD + mod.pow(2, n * k) - mod.pow(2, (n - 1) * k);
            ans *= n;
            out.ans(ans % MOD).ln();
        }
    }
}
