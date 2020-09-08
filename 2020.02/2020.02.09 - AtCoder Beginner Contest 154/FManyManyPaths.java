package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class FManyManyPaths {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int r1 = in.ints(), c1 = in.ints(), r2 = in.ints(), c2 = in.ints();
        long ans = 0;
        ModMath mod = new ModMath(MOD);
        Factorial fact = mod.getFactorial(3_000_001);
        for (int i = r1; i <= r2; i++) {
            long d = fact.ncr(i + c2 + 1, i + 1) - fact.ncr(i + c1, i + 1);
            //System.out.println(d);
            ans += d;
        }
        ans %= MOD;
        ans += MOD;
        ans %= MOD;
        out.ans(ans).ln();
    }
}
