package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class CFennecVsMonster {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = Math.min(in.ints(), n);
        int[] h = in.ints(n);
        IntroSort.sort(h);
        long ans = 0;
        for (int i = 0; i < n - k; i++) ans += h[i];
        out.ans(ans).ln();

    }
}
