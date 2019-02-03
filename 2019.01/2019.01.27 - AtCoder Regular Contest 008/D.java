package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.geo.Vec2d;
import jp.llv.atcoder.lib.structure.LazySegmentTree;
import jp.llv.atcoder.lib.structure.SegmentTree;

import java.util.Arrays;
import java.util.Comparator;

public class D {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {

        Debug.autoEnable();
        long n = in.longs();
        int m = in.ints();
        Query[] queries = new Query[m];
        for (int i = 0; i < m; i++) {
            queries[i] = new Query(i - 1, in.longs(), in.doubles(), in.doubles());
        }
        Arrays.sort(queries, Comparator.comparing(q -> q.machine));
        long last = -1;
        int zip = -1;
        for (int i = 0; i < m; i++) {
            if (queries[i].machine != last) {
                last = queries[i].machine;
                zip++;
            }
            queries[i].zip = zip;
        }
        zip++;
        if (zip == 0) {
            out.ans(1).ln().ans(1).ln();
            return;
        }

        Arrays.sort(queries, Comparator.comparing(q -> q.index));
        //*/

        Vec2d[] array = new Vec2d[zip];
        Vec2d unit = new Vec2d(1, 0);
        Arrays.fill(array, unit);

        /*Lazy*/SegmentTree<Vec2d, Vec2d> st = new /*Lazy*/SegmentTree<>(
                array, Vec2d.class, /*Vec2d.class, */(a, b) -> new Vec2d(a.x * b.x, a.y * b.x + b.y), unit, (x, q) -> q
                //,(q1, q2) -> q2, null
        );
        double max = 1, min = 1;
        for (int i = 0; i < m; i++) {
            int q = queries[i].zip;
            double a = queries[i].a, b = queries[i].b;
            st.update(q, new Vec2d(a, b));
            Vec2d e = st.query(0, zip);
            double v = e.x + e.y;
            max = Math.max(max, v);
            min = Math.min(min, v);
        }
        out.ans(min, 7).ln().ans(max, 7).ln();
    }

    private static class Query {
        int index;
        long machine;
        double a;
        double b;
        int zip;

        public Query(int index, long machine, double a, double b) {
            this.index = index;
            this.machine = machine;
            this.a = a;
            this.b = b;
        }

    }
}
