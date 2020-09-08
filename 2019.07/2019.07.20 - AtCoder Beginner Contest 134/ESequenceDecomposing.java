package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ESequenceDecomposing {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        TreeMap<Integer, Integer> greedy = new TreeMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> q = greedy.lowerEntry(a[i]);
            if (q == null) {
                ans++;
            } else {
                if (q.getValue() == 1) {
                    greedy.remove(q.getKey());
                } else {
                    greedy.put(q.getKey(), q.getValue() - 1);
                }
            }
            greedy.merge(a[i], 1, Integer::sum);
        }
        out.ans(ans).ln();
    }
}
