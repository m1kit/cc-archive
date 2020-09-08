package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.PrimeTable;

public class DSumOfDivisors {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long ans = 0;
        PrimeTable table = new PrimeTable( n + 1);
        for (int i = 1; i <= n; i++) ans += i * (long) table.countDivisors(i);
        out.ans(ans).ln();
    }
}
