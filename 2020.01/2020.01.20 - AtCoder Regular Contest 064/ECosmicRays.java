package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ECosmicRays {

    private static final double EPS = 1e-10;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        double sx = in.doubles(), sy = in.doubles(), gx = in.doubles(), gy = in.doubles();
        int n = in.ints();
        double[] x = new double[n], y = new double[n], r = new double[n];
        int[] visited = new int[n];
        in.doubles(x, y, r);
        double[] dist = new double[n];
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparing(p -> dist[p]));
        for (int i = 0; i < n; i++) {
            dist[i] = Math.max(0.0 , dist(sx, sy, x[i], y[i]) - r[i]);
            q.offer(i);
        }
        while (!q.isEmpty()) {
            int p = q.poll();
            if (visited[p] > 5) continue;
            visited[p]++;
            for (int i = 0; i < n; i++) {
                double d =  Math.max(0.0 , dist(x[p], y[p], x[i], y[i]) - r[i] - r[p]);
                if (dist[p] + d < dist[i] - EPS) {
                    dist[i] = dist[p] + d;
                    q.offer(i);
                }
            }
        }
        double ans = dist(sx, sy, gx, gy);
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dist[i] + Math.max(0.0 , dist(gx, gy, x[i], y[i]) - r[i]));
        }
        out.ans(ans, 10).ln();
    }

    private static double dist(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2, dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }

}
