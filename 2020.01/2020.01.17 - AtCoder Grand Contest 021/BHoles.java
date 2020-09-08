package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.ConvexHull;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2l;

import java.util.Arrays;
import java.util.List;

public class BHoles {

    private static final double PI2 = Math.PI * 2;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m;
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) points[i] = new Point(in.longs(), in.longs());
        List<Point> hull = ConvexHull.makeHull(Arrays.asList(points));
        m = hull.size();
        for (int i = 0; i < m; i++) {
            Point x = hull.get((i + m - 1) % m), y = hull.get(i), z = hull.get((i + 1) % m);
            y.ans = (x.sub(y).rotate().arg() - y.sub(z).rotate().arg()) / PI2;
            if (y.ans < 0) y.ans += 1.0;
        }
        for (int i = 0; i < n; i++) {
            out.ans(points[i].ans, 20).ln();
        }
    }

    private static class Point extends Vec2l {
        double ans;

        public Point(long x, long y) {
            super(x, y);
        }
    }
}
