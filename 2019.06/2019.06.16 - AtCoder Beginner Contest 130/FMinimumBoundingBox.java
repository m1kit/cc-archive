package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class FMinimumBoundingBox {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[][] min = new int[2][3], max = new int[2][3];
        ArrayUtil.fill(min, Integer.MAX_VALUE);
        ArrayUtil.fill(max, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int x = in.ints(), y = in.ints();
            char d = in.string().charAt(0);
            switch (d) {
                case 'L':
                    min[0][0] = Math.min(min[0][0], x);
                    max[0][0] = Math.max(max[0][0], x);
                    break;
                case 'U':
                case 'D':
                    min[0][1] = Math.min(min[0][1], x);
                    max[0][1] = Math.max(max[0][1], x);
                    break;
                case 'R':
                    min[0][2] = Math.min(min[0][2], x);
                    max[0][2] = Math.max(max[0][2], x);
                    break;
            }
            switch (d) {
                case 'D':
                    min[1][0] = Math.min(min[1][0], y);
                    max[1][0] = Math.max(max[1][0], y);
                    break;
                case 'L':
                case 'R':
                    min[1][1] = Math.min(min[1][1], y);
                    max[1][1] = Math.max(max[1][1], y);
                    break;
                case 'U':
                    min[1][2] = Math.min(min[1][2], y);
                    max[1][2] = Math.max(max[1][2], y);
                    break;
            }
        }


        double ans = Double.MAX_VALUE;
        for (long i = 0; i <= 400_000_000; i++) {
            double t = i * 0.5;
            double xmin = min(min[0][1], min[0][0] - t, min[0][2] + t);
            double xmax = max(max[0][1], max[0][0] - t, max[0][2] + t);
            double ymin = min(min[1][1], min[1][0] - t, min[1][2] + t);
            double ymax = max(max[1][1], max[1][0] - t, max[1][2] + t);
            double v = (xmax - xmin) * (ymax - ymin);
            ans = Math.min(ans, v);
        }
        out.ans(ans, 12).ln();
    }

    private static double min(double y, double x, double z) {
        return x < y && x < z ? x : y < z ? y : z;
    }

    private static double max(double x, double y, double z) {
        return x > y && x > z ? x : y > z ? y : z;
    }
}
