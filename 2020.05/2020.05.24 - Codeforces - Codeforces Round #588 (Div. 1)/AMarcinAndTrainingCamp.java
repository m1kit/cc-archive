package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.sparsetable.IntSparseTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AMarcinAndTrainingCamp {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n), b = in.longs(n);
        long ans = 0;
        Set<Long> candidates = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) candidates.add(a[i]);
            }
        }
        outer: for (int i = 0; i < n; i++) {
            for (long cnd: candidates) {
                if ((a[i] & ~cnd) == 0) {
                    ans += b[i];
                    continue outer;
                }
            }
        }
        out.ans(ans).ln();
    }
}
