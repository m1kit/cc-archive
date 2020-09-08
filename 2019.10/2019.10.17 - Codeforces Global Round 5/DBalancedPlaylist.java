package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;
import dev.mikit.atcoder.lib.structure.segmenttree.SegmentTree;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Comparator;
import java.util.TreeSet;

public class DBalancedPlaylist {

    private static final IndexedValue ZERO = new IndexedValue(-1, Long.MAX_VALUE);

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n);
        int[] ans = new int[n];
        {
            long max = IntMath.max(a), min = IntMath.min(a);
            if (min > (max - 1) / 2) {
                for (int i = 0; i < n; i++) out.ans(-1);
                out.ln();
                return;
            }
        }
        IndexedValue[] values = new IndexedValue[n];
        for (int i = 0; i < n; i++) values[i] = new IndexedValue(i, a[i]);
        IntroSort.sort(values, Comparator.comparing(val -> val.value));
        ArrayUtil.reverse(values, 0, n);
        TreeSet<Integer> done = new TreeSet<>();

        IntSegmentTree st = new IntSegmentTree(a, Math::min, Integer.MAX_VALUE, Math::min);
        for (int index = 0; index < n; index++) {
            int i = values[index].index;
            long threshold = (a[i] - 1) / 2;


            long mintoLast = st.query(i + 1, n);
            Integer bound = done.higher(i);
            if (bound != null) {
                if (st.query(i + 1, bound) > threshold) {
                    ans[i] = ans[bound] + bound - i;
                    done.add(i);
                    continue;
                }
            } else if (!done.isEmpty()) {
                bound = done.first();
                if (Math.min(st.query(0, bound), mintoLast) > threshold) {
                    ans[i] = ans[bound] + bound + n - i;
                    done.add(i);
                    continue;
                }
            }
            done.add(i);


            int min, max;
            if (mintoLast <= threshold) {
                min = i + 1;
                max = n;
                while (max - min > 1) {
                    int mid = (min + max) / 2;
                    if (st.query(i + 1, mid) <= threshold) max = mid;
                    else min = mid;
                }
                ans[i] = min - i;
            } else {
                min = 0;
                max = i;
                while (max - min > 1) {
                    int mid = (min + max) / 2;
                    if (st.query(0, mid) <= threshold) max = mid;
                    else min = mid;
                }
                ans[i] = n - i + min;
            }
        }
        out.ans(ans).ln();
    }

    private static class IndexedValue {
        int index;
        long value;

        public IndexedValue(int index, long value) {
            this.index = index;
            this.value = value;
        }
    }
}
