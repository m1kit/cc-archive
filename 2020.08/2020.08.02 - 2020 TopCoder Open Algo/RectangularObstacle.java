package dev.mikit.atcoder;

import java.util.Random;

public class RectangularObstacle {
    public long countReachable(int kllllll, int kllll, int kll, int kl, int k) {
        Random random = new Random();

        while (true) {
            long x1 = -random.nextInt(1_000_000);
            long x2 = random.nextInt(1_000_000);
            long y1 = random.nextInt(500_000);
            long y2 = y1 + random.nextInt(500_000);
            long s = random.nextInt(1_000_000_000);
            long r1 = countReachable((long) x1, x2, y1, y2, s);
            long r2 = risu((long) x1, x2, y1, y2, s);
            if (r1 != r2) {
                System.out.println(x1 + ", " + x2 + ", " + y1 + ", " + y2 + ", " + s);
            }
        }
    }

    private static long countReachable(long x1, long x2, long y1, long y2, long s) {
        long ans = 2 * s * (s + 1) + 1;
        for (long x = x1; x <= x2; x++) {
            long top = s - Math.abs(x);
            ans -= Math.max(0, top - y1 + 1);
            if (top <= y2) continue;
            long dl = y2 + 1 + Math.abs(x1 - 1), dr = y2 + 1 + Math.abs(x2 + 1);
            long h = y2;
            if (dl < s) {
                h = Math.max(h, y2 + 1 + (s - dl) - (x - (x1 - 1)));
            }
            if (dr < s) {
                h = Math.max(h, y2 + 1 + (s - dr) - ((x2 + 1) - x));
            }
            ans += h - y2;
        }
        return ans;
    }

    private static long sq(long x) {
        return x * x;
    }

    private static long risu(long x1, long x2, long y1, long y2, long s) {
        long res = 0;
        if (-s < x1) {
            res += sq(x1 + s);
        }
        if (s > x2) {
            res += sq(s - x2);
        }
        long m = x1 + x2;
        for (long x = Math.max(x1, -s); x <= Math.min(x2, s); x++) {
            res += Math.min(s - Math.abs(x), y1 - 1) - (Math.abs(x) - s) + 1;
            res += Math.max(s - (x2 - x1 + y2 + 2) + Math.abs(x - m), 0);
        }
        return res;
    }
}
