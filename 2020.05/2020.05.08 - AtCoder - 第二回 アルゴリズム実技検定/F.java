    package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2i;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

    public class F {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        Vec2i[] vs = new Vec2i[n];
        in.objs(vs, Vec2i::new);
        PriorityQueue<Vec2i> q1 = new PriorityQueue<>(Comparator.comparing(v -> v.x));
        PriorityQueue<Vec2i> q2 = new PriorityQueue<>(Comparator.comparing(v -> -v.y));
        q1.addAll(Arrays.asList(vs));
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            while (!q1.isEmpty() && q1.peek().x <= i) q2.offer(q1.poll());
            ans += q2.poll().y;
            out.ans(ans).ln();
        }
    }
}
