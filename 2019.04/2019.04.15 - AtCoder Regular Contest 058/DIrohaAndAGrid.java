package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class DIrohaAndAGrid {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h = in.ints(), w = in.ints(), a = in.ints(), b = in.ints();
        ModMath mod = new ModMath();
        Factorial fact = mod.getFactorial(200_001);
        long ans = 0;
        for (int i = 1; i <= h - a; i++) {
            long x = fact.ncr(b + i - 2, i - 1);
            long y = fact.ncr(h - i + w - b - 1, h - i);
            ans += (x * y) % MOD;
            ans %= MOD;
        }
        out.ansln(ans);
    }
}
