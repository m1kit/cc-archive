package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.structure.MultiTreeSet;

import java.util.Arrays;
import java.util.Comparator;

public class CCircularCircles {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        out.setCaseLabel(LightWriter2.CaseLabel.GCJ);
        if (false) in.next();
        int n = in.ints(), m = in.ints(), e = in.ints(), k = in.ints(), nm = n * m;
        long[] xs = longs(n, k, m, in), ys = longs(n, k, m, in), is = longs(e, k, nm + n, in), ws = longs(e, k, 1_000_000_000, in);
        long[] inb = new long[n], outb = new long[n];
        for (int i = 0; i < n; i++) {
            inb[i] = Math.min(xs[i], ys[i]);
            outb[i] = Math.max(xs[i], ys[i]);
        }
        Subcircle[] subcircles = new Subcircle[n];
        for (int i = 0; i < n; i++) {
            int c2 = (int) (outb[i] - inb[i]);
            subcircles[i] = new Subcircle(m - c2, c2);
        }
        Circle circle = new Circle(n, subcircles);
        long ans = 1;
        long[] vs = new long[e];
        for (int i = 0; i < e; i++) {
            if (is[i] < nm) {
                int big = (int) (is[i] / m), small = (int) ((is[i] - outb[big] + m) % m);
                circle.updateCircle(big, small, ws[i]);
            } else {
                int ind = (int) (is[i] - nm);
                circle.updateEdge(ind, ws[i]);
            }
            vs[i] = circle.getAnswer();
            vs[i] %= MOD;
            ans *= vs[i];
            ans %= MOD;
        }
        out.cases(testNumber).ans(ans).ln();
        //System.out.println(Arrays.toString(is));
        //System.out.println(Arrays.toString(ws));
        //System.out.println(Arrays.toString(vs));
    }

    private static class Circle {
        MultiTreeSet<Long> s = new MultiTreeSet<>(Comparator.<Long>reverseOrder());
        Subcircle[] subcircles;
        long[] edges;
        long sum, reduced;

        Circle(int n, Subcircle[] subcircles) {
            this.subcircles = subcircles;
            edges = new long[n];
            Arrays.fill(edges, 1);
            sum = n;
            s.add(1L, n);
            for (int i = 0; i < n; i++) {
                sum += subcircles[i].sum;
                reduced += subcircles[i].getCost();
                s.add(subcircles[i].getOptional());
            }
        }

        void updateEdge(int i, long v) {
            s.remove(edges[i]);
            s.add(v);
            sum += v - edges[i];
            edges[i] = v;
        }

        void updateCircle(int i, int j, long v) {
            sum -= subcircles[i].sum;
            reduced -= subcircles[i].getCost();
            s.remove(subcircles[i].getOptional());
            subcircles[i].update(j, v);
            s.add(subcircles[i].getOptional());
            sum += subcircles[i].sum;
            reduced += subcircles[i].getCost();
        }

        long getAnswer() {
            return sum - reduced - s.peek();
        }
    }

    private static class Subcircle {
        MultiTreeSet<Long> s1 = new MultiTreeSet<>(Comparator.<Long>reverseOrder());
        MultiTreeSet<Long> s2 = new MultiTreeSet<>(Comparator.<Long>reverseOrder());
        long sum = 0;
        long peek1 = 1, peek2 = 0;
        long[] c1, c2;

        Subcircle(int c1, int c2) {
            s1.add(1L, c1);
            s2.add(1L, c2);
            if (c2 > 0) peek2 = 1;
            sum = c1 + c2;
            this.c1 = new long[c1];
            this.c2 = new long[c2];
            Arrays.fill(this.c1, 1L);
            Arrays.fill(this.c2, 1L);
        }

        public void update(int i, long v) {
            if (i < c1.length) {
                s1.remove(c1[i]);
                s1.add(v);
                sum += v - c1[i];
                c1[i] = v;
                peek1 = s1.peek();
            } else {
                i -= c1.length;
                s2.remove(c2[i]);
                s2.add(v);
                sum += v - c2[i];
                c2[i] = v;
                peek2 = s2.peek();
            }
        }

        long getCost() {
            return Math.max(peek1, peek2);
        }

        long getOptional() {
            return Math.min(peek1, peek2);
        }
    }

    private static long[] longs(int n, int k, int m, LightScanner2 in) {
        long[] a = new long[n];
        for (int i = 0; i < k; i++) a[i] = in.longs();
        long[] p = in.longs(3);
        for (int i = k; i < n; i++) a[i] = (p[0] * a[i - 2] + p[1] * a[i - 1] + p[2]) % m;
        return a;
    }
}
