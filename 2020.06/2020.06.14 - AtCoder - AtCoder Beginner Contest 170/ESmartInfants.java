package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;

import java.util.*;

public class ESmartInfants {

    private static final int K = 200_010;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        List<TreeMap<Integer, Integer>> list = new ArrayList<>(K);
        for (int i = 0; i < K; i++) list.add(new TreeMap<>());
        int n = in.ints(), q = in.ints();
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ints();
            b[i] = in.ints() - 1;
            list.get(b[i]).merge(a[i], 1, Integer::sum);
        }
        long[] max = new long[K];
        Arrays.fill(max, Integer.MAX_VALUE);
        for (int i = 0; i < K; i++) {
            if (list.get(i).isEmpty()) continue;
            max[i] = list.get(i).lastKey();
        }
        IntSegmentTree st = new IntSegmentTree(max, Math::min, Integer.MAX_VALUE, (x, u) -> u);
        for (int i = 0; i < q; i++) {
            int c = in.ints() - 1, from = b[c], to = in.ints() - 1;
            TreeMap<Integer, Integer> x = list.get(from), y = list.get(to);
            if (x.get(a[c]) == 1) {
                x.remove(a[c]);
                if (x.isEmpty()) st.update(from, Integer.MAX_VALUE);
                else st.update(from, x.lastKey());
            } else x.merge(a[c], -1, Integer::sum);
            y.merge(a[c], 1, Integer::sum);
            st.update(to, y.lastKey());
            out.ans(st.query(0, K)).ln();
            b[c] = to;
        }
    }
}
