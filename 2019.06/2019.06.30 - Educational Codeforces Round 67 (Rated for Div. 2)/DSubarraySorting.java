package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.sort.MergeSort;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;

import java.util.Arrays;
import java.util.Comparator;

public class DSubarraySorting {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int testCases = in.ints();
        loop:
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            int[] a = in.ints(n), b = in.ints(n);
            Value[] va = new Value[n], vb = new Value[n];
            for (int i = 0; i < n; i++) {
                va[i] = new Value(i, a[i]);
                vb[i] = new Value(i, b[i]);
            }
            MergeSort.sort(va, Comparator.comparing(value -> value.value));
            MergeSort.sort(vb, Comparator.comparing(value -> value.value));
            int[] mt = new int[n];
            for (int i = 0; i < n; i++) {
                if (va[i].value != vb[i].value) {
                    out.noln();
                    continue loop;
                }
                mt[va[i].index] = vb[i].index;
            }
            //System.out.println(Arrays.toString(mt));

            IntSegmentTree st = new IntSegmentTree(new long[n + 1], Math::max, 0, Math::max);
            for (int i = 0; i < n; i++) {
                if (st.query(0, a[i]) > mt[i]) {
                    //System.out.println("FAIL: " + i);
                    out.noln();
                    continue loop;
                }
                st.update(a[i], mt[i]);
            }
            out.yesln();
        }
    }

    private static class Value {
        int index, value;

        public Value(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
