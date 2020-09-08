package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;
import java.util.TreeSet;

public class A2PerimetricChapter2 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        int n = in.ints(), pk = in.ints();
        long[] l = new long[n], w = new long[n], h = new long[n + 1];
        for (int i = 0; i < pk; i++) l[i] = in.longs();
        long[] pa = in.longs(4);
        for (int i = pk; i < n; i++) l[i] = (pa[0] * l[i - 2] + pa[1] * l[i - 1] + pa[2]) % pa[3] + 1;
        for (int i = 0; i < pk; i++) w[i] = in.longs();
        long[] pc = in.longs(4);
        for (int i = pk; i < n; i++) w[i] = (pc[0] * w[i - 2] + pc[1] * w[i - 1] + pc[2]) % pc[3] + 1;
        for (int i = 0; i < pk; i++) h[i] = in.longs();
        long[] pb = in.longs(4);
        for (int i = pk; i < n; i++) h[i] = (pb[0] * h[i - 2] + pb[1] * h[i - 1] + pb[2]) % pb[3] + 1;

        long[] p = new long[n];
        long[] hv = new long[n], vv = new long[n];
        TreeSet<Segment> segments = new TreeSet<>();
        long prod = 1, hval = 0, vval = 0;
        for (int i = 0; i < n; i++) {
            hval += w[i];
            Segment ls = new Segment(l[i], l[i] + w[i]);
            Segment rs = null;
            while ((rs = segments.ceiling(ls)) != null && rs.l <= ls.r) {
                segments.remove(rs);
                hval -= Math.min(ls.r, rs.r) - Math.max(ls.l, rs.l);
                ls.l = Math.min(ls.l, rs.l);
                ls.r = Math.max(ls.r, rs.r);
            }
            while ((rs = segments.floor(ls)) != null && ls.l <= rs.r) {
                segments.remove(rs);
                hval -= Math.min(ls.r, rs.r) - Math.max(ls.l, rs.l);
                ls.l = Math.min(ls.l, rs.l);
                ls.r = Math.max(ls.r, rs.r);
            }
            segments.add(ls);

            hv[i] = hval;
            vv[i] = vval + h[i] * segments.size();
            vval += (h[i] - h[i + 1]) * segments.size();

            p[i] = hv[i] * 2 + vv[i] * 2;
            prod *= p[i] % MOD;
            prod %= MOD;
        }
        /*
        System.out.println("===");
        System.out.println(segments);
        System.out.println("L: " + Arrays.toString(l));
        System.out.println("W: " + Arrays.toString(w));
        System.out.println("H: " + Arrays.toString(h));
        System.out.println("P: " + Arrays.toString(p));
        System.out.println("h: " + Arrays.toString(hv));
        System.out.println("v: " + Arrays.toString(vv));
        //*/
        out.cases(testNumber).ans(prod).ln();
    }

    private static class Segment implements Comparable<Segment> {
        long l, r;

        Segment(long l, long r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Segment o) {
            return Long.compare(l, o.l);
        }

        @Override
        public String toString() {
            return "[" + l + ", " + r + "]";
        }
    }
}
