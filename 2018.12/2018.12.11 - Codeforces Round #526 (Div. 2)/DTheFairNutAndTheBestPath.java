package jp.llv.atcoder;

import jp.llv.atcoder.lib.graph.*;
import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DTheFairNutAndTheBestPath {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static long ans = 0;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        IntNodeSet<NM, Void> g = new IntNodeSet<>(n);
        for (int i = 0; i < n; i++) {
            g.getNode(i).setMeta(new NM(in.longs()));
        }
        for (int i = 1; i < n; i++) {
            int u = in.ints() - 1, v = in.ints() - 1;
            long c = in.ints();
            g.addEdge(u, v, c);
        }
        resolv(g, g.getNode(0));
        // System.out.println(g);
        out.println(ans);
    }

    private static List<Long> reuse = new ArrayList<>();

    private static void resolv(IntNodeSet<NM, Void> g, Node<NM, IntEdge<NM, Void>> c) {
        c.getMeta().r = true;
        for (IntEdge<NM, Void> e : c.getEdges()) {
            if (e.getTo().getMeta().r) {
                continue;
            }
            resolv(g, e.getTo());
        }
        reuse.clear();
        reuse.add(0L);
        for (IntEdge<NM, Void> e : c.getEdges()) {
            reuse.add(e.getTo().getMeta().m - e.getWeight());
        }
        reuse.sort(Comparator.reverseOrder());

        // System.out.println(c + " : " + reuse);

        c.getMeta().m = reuse.get(0) + c.getMeta().w;
        ans = Math.max(ans, reuse.get(0) + c.getMeta().w);
        if (reuse.size() > 1) {

            ans = Math.max(ans, reuse.get(0) + reuse.get(1) + c.getMeta().w);
        }
    }

    private static class NM {
        private long w;
        private long m;
        private boolean r = false;

        NM(long w) {
            this.w = w;
        }

        @Override
        public String toString() {
            return "NM{" +
                    "w=" + w +
                    ", m=" + m +
                    '}';
        }
    }
}
