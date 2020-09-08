package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class BNiceShopping {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints(), s = in.ints();
        int[] a = in.ints(n), b = in.ints(m);
        int ans = IntMath.min(a) + IntMath.min(b);
        for (int i = 0; i < s; i++) {
            int x = in.ints() - 1, y = in.ints() - 1, c = in.ints();
            ans = Math.min(ans, a[x] + b[y] - c);
        }
        out.ans(ans).ln();
    }
}
