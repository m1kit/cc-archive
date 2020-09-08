package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;

import java.util.Arrays;

public class AnchoredBalloon {

    private static final int MOD = (int) 1e9 + 7;
    private static final double EPS = 1e-5;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int testcase = 0;
        while (n > 0) {
            Point[] points = new Point[n];
            double ans = 1e5;
            for (int i = 0; i < n; i++) {
                points[i] = new Point(in.doubles(), in.doubles(), in.doubles());
                ans = Math.min(ans, points[i].r);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    Point p1 = points[i], p2 = points[j];
                    double dp = Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2);
                    double d = Math.sqrt(Math.max(dp, 0));
                    double r1p = Math.pow(p1.r, 2), r2p = Math.pow(p2.r, 2);
                    if (r1p > dp + r2p + EPS || r2p > dp + r1p + EPS) {
                        continue;
                    }

                    double w1 = (dp + (p1.r * p1.r) - (p2.r * p2.r)) / (2 * d);
                    double hp = p1.r * p1.r - w1 * w1;
                    double h = Math.sqrt(Math.max(0, hp));
                    ans = Math.min(ans, h);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    outer:
                    for (int k = 0; k < j; k++) {
                        Point[] p = {points[i], points[j], points[k]};
                        double[] c = new double[3];
                        for (int l = 0; l < 3; l++) c[l] = p[l].r * p[l].r - p[l].x * p[l].x - p[l].y * p[l].y;
                        double det = (p[0].x - p[1].x) * (p[1].y - p[2].y) - (p[1].x - p[2].x) * (p[0].y - p[1].y);
                        double x = (p[1].y - p[2].y) * (c[1] - c[0]) + (p[1].y - p[0].y) * (c[2] - c[1]);
                        double y = (p[2].x - p[1].x) * (c[1] - c[0]) + (p[0].x - p[1].x) * (c[2] - c[1]);
                        if (Math.abs(det) < EPS) {
                            continue;
                        }

                        x /= 2 * det;
                        y /= 2 * det;
                        double hPow = Math.pow(p[0].r, 2) - Math.pow(x - p[0].x, 2) - Math.pow(y - p[0].y, 2);
                        if (hPow < -EPS) {
                            continue;
                        }

                        double[] oc = new double[3];
                        for (int l = 0; l < 3; l++) {
                            double x1 = p[(l + 1) % 3].x - p[l].x, x2 = x - p[l].x;
                            double y1 = p[(l + 1) % 3].y - p[l].y, y2 = y - p[l].y;
                            oc[l] = x1 * y2 - x2 * y1;
                        }
                        for (int l = 0; l < 3; l++) {
                            if (Math.abs(oc[l]) < EPS) {
                                continue outer;
                            }
                        }
                        for (int l = 0; l < 2; l++) {
                            if ((oc[l] < -EPS) != (oc[l + 1] < -EPS)) {
                                continue outer;
                            }
                        }

                        double h = Math.sqrt(Math.max(0, hPow));
                        ans = Math.min(ans, h);
                    }
                }
            }

            out.ansln(ans);
            n = in.ints();
            testcase++;
        }
    }

    private static class Point {
        double x, y, r;

        public Point(double x, double y, double r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", r=" + r +
                    '}';
        }
    }
}
