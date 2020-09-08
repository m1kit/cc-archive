package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;
import java.util.Comparator;

public class DExtraElement {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Term[] a = new Term[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Term(i + 1, in.longs());
        }
        IntroSort.sort(a, Comparator.comparing(term -> term.value));
        if (n <= 3) {
            out.ans(1).ln();
            return;
        }

        outer: for (long d : new long[]{a[2].value - a[1].value, a[1].value - a[0].value, a[2].value - a[0].value}) {
            long last = a[1].value;
            boolean success = true;
            for (int i = 2; i < n; i++) {
                success &= ((a[i].value - last) == d);
                last = a[i].value;
            }
            if (success) {
                out.ans(a[0].index).ln();
                return;
            }

            int index = -1;
            last = a[0].value;
            for (int i = 1; i < n; i++) {
                if (d != a[i].value - last) {
                    if (index == -1) {
                        index = a[i].index;
                    } else {
                        continue outer;
                    }
                } else {
                    last = a[i].value;
                }
            }
            if (index == -1) {
                out.ans(a[0].index).ln();
            } else {
                out.ans(index).ln();
            }
            return;
        }
        out.ans(-1).ln();
    }

    private static class Term {
        int index;
        long value;

        Term(int index, long value) {
            this.index = index;
            this.value = value;
        }
    }
}
