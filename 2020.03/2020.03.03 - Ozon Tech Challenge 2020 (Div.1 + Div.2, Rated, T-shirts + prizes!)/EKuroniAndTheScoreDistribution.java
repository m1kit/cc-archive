package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.*;
import java.util.stream.IntStream;

public class EKuroniAndTheScoreDistribution {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long start = System.currentTimeMillis();
        int n = in.ints();
        long m = in.longs();
        List<Long> added = new ArrayList<>();
        Map<Long, Integer> map = new HashMap<>();
        for (long cur = 1; 0 < m && added.size() < n && System.currentTimeMillis() - start < 900; cur++) {
            int p = map.getOrDefault(cur, 0);
            if (p > m) continue;
            m -= p;
            for (long x : added) map.merge(x + cur, 1, Integer::sum);
            added.add(cur);
        }
        if (m == 0) {
            long min = 1;
            while (added.contains(min)) min++;
            long max = 1_000_000_000;
            while (added.size() < n) {
                added.add(max);
                max -= min;
            }
        } else if (added.size() != n || m > 0) {
            out.ans(-1).ln();
            return;
        }
        added.sort(Comparator.naturalOrder());
        for (long x : added) out.ans(x);
        out.ln();
    }
}
