package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class DSwords {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int max = IntMath.max(a);
        long gcd = -1;
        long insufficient = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == max) continue;
            else if (gcd == -1) gcd = max - a[i];
            else gcd = IntMath.gcd(gcd, max - a[i]);
            insufficient += max - a[i];
        }
        if (gcd == -1) {
            throw new RuntimeException();
        }
        out.ans(insufficient / gcd).ans(gcd).ln();
    }
}
