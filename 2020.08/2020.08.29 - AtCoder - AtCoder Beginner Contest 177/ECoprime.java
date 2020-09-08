package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.PrimeTable;
import dev.mikit.atcoder.lib.structure.IntMultiSet;

import java.util.HashSet;
import java.util.Set;

public class ECoprime {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints();
        int[] a = in.ints(n);
        long g = IntMath.gcd(a);
        if (g != 1) {
            out.ans("not coprime").ln();
            return;
        }
        PrimeTable table = new PrimeTable(1_000_001);
        int[] counts = new int[1_000_001];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int e : table.primeFactorize(a[i]).keySet()) counts[e]++;
        }
        for (int i = 0; i <= 1_000_000; i++) {
            if (counts[i] >= 2) {
                out.ans("setwise coprime").ln();
                return;
            }
        }
        out.ans("pairwise coprime").ln();
    }
}
