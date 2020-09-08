package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class CReconciled {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        ModMath mod = new ModMath();
        Factorial fact = mod.getFactorial(100_001);
        if (Math.abs(n - m) > 1) {
            out.ansln(0);
            return;
        } else if (Math.abs(n - m) == 1) {
            out.ansln(fact.fact(n) * fact.fact(m) % MOD);
        } else {
            long ans = 2;
            ans *= fact.fact(n);
            ans %= MOD;
            ans *= fact.fact(m);
            ans %= MOD;
            out.ansln(ans);
        }
    }
}
