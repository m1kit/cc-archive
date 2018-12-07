package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.structure.Vec2i;
import jp.llv.atcoder.lib.structure.Vec3i;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), m = in.ints();
        Vec3i[] x = new Vec3i[n];
        for (int i = 0; i < n; i++) {
            x[i] = new Vec3i(in.ints(), in.ints(), i);
        }

        PriorityQueue<Vec3i> q = new PriorityQueue<>(Comparator.comparing(v -> v.x - v.y));

        long ans = 0;
        long sum = 0;
        long nsum = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, sum + nsum + x[i].x);
            q.add(x[i]);
            sum += x[i].y;
            nsum += (x[i].x - x[i].y);
            if (q.size() >= m) {
                Vec3i p = q.poll();
                nsum -= (p.x - p.y);
            }
        }
        out.println(ans);
    }
}
