package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;

public class CTiles {

    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        ModMath mod = new ModMath(MOD);
        int w = in.ints(), h = in.ints();
        long ans = 4;
        ans *= mod.pow(2, w - 1);
        ans %= MOD;
        ans *= mod.pow(2, h - 1);
        ans %= MOD;
        out.ans(ans).ln();
    }
}
