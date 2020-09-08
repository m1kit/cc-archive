package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.structure.segmenttree.IntLazySegmentTree;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;

import java.util.Arrays;
import java.util.Comparator;

public class FScalarQueries {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n);
        int[] b = new int[n];
        {
            class E {
                long v;
                int i;

                E(long v, int i) {
                    this.v = v;
                    this.i = i;
                }
            }
            E[] tmp = new E[n];
            for (int i = 0; i < n; i++) {
                tmp[i] = new E(a[i], i);
            }
            IntroSort.sort(tmp, Comparator.comparing(t -> t.v));
            for (int i = 0; i < n; i++) {
                b[tmp[i].i] = i;
            }
        }


        long[] m = new long[n];
        for (int i = 0; i < n; i++) {
            m[i] = (i + 1L) * (n - i) % MOD;
        }
        {
            IntSegmentTree index = new IntSegmentTree(new long[n], (x, y) -> (x + y) % MOD, 0, (x, u) -> u);
            for (int i = 0; i < n; i++) {
                long left = index.query(0, b[i]);
                long right = n - i;
                m[i] += (left * right) % MOD;
                m[i] %= MOD;
                index.update(b[i], i + 1);
            }
        }
        {
            IntSegmentTree index = new IntSegmentTree(new long[n], (x, y) -> (x + y) % MOD, 0, (x, u) -> u);
            for (int i = n - 1; i >= 0; i--) {
                long right = index.query(0, b[i]);
                long left = i + 1;
                m[i] += left * right % MOD;
                m[i] %= MOD;
                index.update(b[i], n - i);
            }
        }


        //System.out.println(Arrays.toString(m));

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += a[i] * m[i] % MOD;
            ans %= MOD;
        }
        out.ans(ans).ln();
    }
}
