package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.PrimeTable;

public class ChefAndMaximumStarValue {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            int[] a = in.ints(n);
            int[] divisors = new int[IntMath.max(a) + 1];
            PrimeTable table = new PrimeTable(1_000_003);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, divisors[a[i]]);
                for (int d : table.getDivisors(a[i])) divisors[d]++;
            }
            out.ans(ans).ln();
        }
    }
}
