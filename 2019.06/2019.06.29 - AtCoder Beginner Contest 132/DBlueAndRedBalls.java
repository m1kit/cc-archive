package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class DBlueAndRedBalls {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        ModMath mod = new ModMath(MOD);
        Factorial fact = mod.getFactorial(4001);
        for (int i = 1; i <= k; i++) {
            if (n - i - k + 1 < 0) {
                out.ans(0).ln();
            } else {
                out.ans(fact.nhr(i, k - i) * fact.nhr(i + 1, n - k - i + 1) % MOD).ln();
            }
        }
    }
}