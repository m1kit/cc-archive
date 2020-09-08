package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.structure.segmenttree.IntLazySegmentTree;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;
import dev.mikit.atcoder.lib.structure.segmenttree.LazySegmentTree;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FIHateShortestPathProblem {

    private static final int INF = (int) 1e7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int h = in.ints(), w = in.ints();
        TreeMap<Integer, Integer> set = new TreeMap<>();
        IntSegmentTree st = new IntSegmentTree(new long[w], Math::min, INF, (x, u) -> u);
        for (int i = 0; i < w; i++) set.put(i, 0);
        for (int i = 1; i <= h; i++) {
            int a = in.ints() - 1, b = in.ints();
            int delta = INF;
            Integer key;
            while ((key = set.ceilingKey(a)) != null && key < b) {
                delta = Math.min(delta, set.get(key) + (b - key));
                st.update(key, INF);
                set.remove(key);
            }
            if (set.containsKey(b)) delta = Math.min(delta, set.get(b));
            if (b != w) {
                set.put(b, delta);
                st.update(b, delta);
            }

            long min = st.query(0, w);
            out.ans(min >= INF ? -1 : min + i).ln();
        }
    }

    private static class Entry implements Comparable<Entry> {
        int index;
        int delta;

        Entry(int index, int delta) {
            this.index = index;
            this.delta = delta;
        }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(delta, o.delta);
        }
    }
}
