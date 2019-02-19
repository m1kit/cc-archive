package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.geo.Vec2l;
import jp.llv.atcoder.lib.sort.IntroSort;
import jp.llv.atcoder.lib.sort.MergeSort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BYetAnotherArrayPartitioningTask {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints(), m = in.ints(), k = in.ints();
        Vec2l[] a = new Vec2l[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Vec2l(i, in.longs());
        }

        long sum = 0;
        MergeSort.sort(a, Comparator.comparing(x -> -x.y));
        PriorityQueue<Long> indice = new PriorityQueue<>();
        for (int i = 0; i < m * k; i++) {
            indice.add(a[i].x);
            sum += a[i].y;
        }

        out.ans(sum).ln();

        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                indice.poll();
            }
            out.ans(indice.poll() + 1);
        }
        out.ln();
    }
}
