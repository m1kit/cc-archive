package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.geo.Vec2i;
import jp.llv.atcoder.lib.sort.MergeSort;

import java.util.Comparator;

public class BLunarNewYearAndFoodOrdering {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints(), m = in.ints();
        Vec2i[] dishes = new Vec2i[n];
        for (int i = 0; i < n; i++) {
            dishes[i] = new Vec2i(in.ints(), 0);
        }
        for (int i = 0; i < n; i++) {
            dishes[i].y = in.ints();
        }
        Vec2i[] cheapq = dishes.clone();
        MergeSort.sort(cheapq, Comparator.comparing(dish -> dish.y));
        int cur = 0;
        for (int i = 0; i < m; i++) {
            int t = in.ints() - 1, d = in.ints();
            long cost = 0;
            long order = Math.min(d, dishes[t].x);
            d -= order;
            dishes[t].x -= order;
            cost += dishes[t].y * order;
            while (cur < n && d > 0) {
                order = Math.min(cheapq[cur].x, d);
                d -= order;
                cheapq[cur].x -= order;
                cost += cheapq[cur].y * order;
                if (d > 0) {
                    cur++;
                }
            }
            if (cur == n && d > 0) {
                out.ans(0).ln();
            } else {
                out.ans(cost).ln();
            }
        }
    }
}
