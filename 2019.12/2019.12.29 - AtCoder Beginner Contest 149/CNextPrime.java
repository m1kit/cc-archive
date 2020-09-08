package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.PrimeTable;

import java.util.List;

public class CNextPrime {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        for (int x : new PrimeTable(1_000_000).gerPrimes()) {
            if (n <= x) {
                out.ans(x).ln();
                return;
            }
        }
    }
}
