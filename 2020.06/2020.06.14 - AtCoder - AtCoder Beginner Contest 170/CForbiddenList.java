package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CForbiddenList {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int x = in.ints(), n = in.ints();
        int[] p = in.ints(n);
        int ans = 0;
        outer: for (int i = 0; i <= 101; i++) {
            for (int j = 0; j < n; j++) {
                if (p[j] == i) continue outer;
            }
            if (Math.abs(i - x) < Math.abs(ans - x)) ans = i;
        }
        out.ans(ans).ln();
    }
}
