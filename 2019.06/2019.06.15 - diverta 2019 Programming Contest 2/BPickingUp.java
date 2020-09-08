package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BPickingUp {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        if (n == 1) {
            out.ans(1).ln();
            return;
        }

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(in.ints(), in.ints());
        }
        IntroSort.sort(points, Comparator.comparing(p -> p.x));
        Set<PQ> pqs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                pqs.add(new PQ(points[i].x - points[j].x, points[i].y - points[j].y));
                pqs.add(new PQ(points[j].x - points[i].x, points[j].y - points[i].y));
            }
        }

        //System.out.println(pqs);

        int ans = Integer.MAX_VALUE;
        Set<Point> tmp = new HashSet<>();
        for (PQ pq : pqs) {
            tmp.clear();

            int v = 0;
            for (int i = 0; i < n; i++) {
                boolean p = tmp.contains(points[i].plus(pq)), q = tmp.contains(points[i].minus(pq));
                if (p && q) {
                    v--;
                } else if (!p && !q) {
                    v++;
                }
                tmp.add(points[i]);
            }

            //System.out.println(pq + " => " + v);
            ans = Math.min(ans, v);
        }
        out.ans(ans).ln();
    }

    private static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        Point minus(PQ pq) {
            return new Point(x - pq.p, y - pq.q);
        }

        Point plus(PQ pq) {
            return new Point(x + pq.p, y + pq.q);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = (int) (x ^ (x >>> 32));
            result = 31 * result + (int) (y ^ (y >>> 32));
            return result;
        }
    }

    private static class PQ {
        long p, q;

        PQ(long p, long q) {
            this.p = p;
            this.q = q;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PQ pq = (PQ) o;

            if (p != pq.p) return false;
            return q == pq.q;
        }

        @Override
        public int hashCode() {
            int result = (int) (p ^ (p >>> 32));
            result = 31 * result + (int) (q ^ (q >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return "PQ{" +
                    "p=" + p +
                    ", q=" + q +
                    '}';
        }
    }
}
