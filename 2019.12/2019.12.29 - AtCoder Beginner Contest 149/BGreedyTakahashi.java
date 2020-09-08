package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BGreedyTakahashi {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long a = in.longs(), b = in.longs(), k = in.longs();
        long e1 = Math.min(a, k);
        a -= e1;
        k -= e1;
        long e2 = Math.min(b, k);
        b -= e2;
        k -= e2;
        out.ans(a).ans(b).ln();
    }
}
