package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.HashSet;

public class ENewYearParties {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] x = in.ints(n);
        IntroSort.sort(x);
        HashSet<Integer> min = new HashSet<>(), max = new HashSet<>();
        int lo = -100, hi = -100;
        for (int i = 0; i < n; i++) {
            if (hi < x[i] - 1) {
                hi = x[i] + 1;
                min.add(hi);
            }
            if (lo < x[i] + 1) {
                lo = Math.max(lo + 1, x[i] - 1);
                max.add(lo);
            }
        }
        out.ans(min.size()).ans(max.size()).ln();
    }
}
