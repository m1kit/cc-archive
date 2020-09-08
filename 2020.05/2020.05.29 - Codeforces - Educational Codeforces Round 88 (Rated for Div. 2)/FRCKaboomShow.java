package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class FRCKaboomShow {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] x = new int[n], y = new int[n], sx = new int[n], sy = new int[n], s = new int[n];
        in.ints(x, y, sx, sy, s);
        double[] len = new double[n];
        for (int i = 0; i < n; i++) len[i] = Math.hypot(sx[i], sy[i]) / s[i];
        double ans = Double.POSITIVE_INFINITY;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int dx = x[i] - x[j], dy = y[i] - y[j];
                int detinv = sx[i] * sy[j] - sx[j] * sy[i];
                if (detinv == 0) {
                    if (dx * sy[i] != dy * sx[i]) continue;
                    boolean f1 = Integer.signum(sx[i]) == Integer.signum(-dx) && Integer.signum(sy[i]) == Integer.signum(-dy);
                    boolean f2 = Integer.signum(sx[j]) == Integer.signum(dx) && Integer.signum(sy[j]) == Integer.signum(dy);
                    double dist = Math.hypot(dx, dy);
                    if (f1 && f2) ans = Math.min(ans, dist / (s[i] + s[j]));
                    else if (f1) ans = Math.min(ans, dist / s[i]);
                    else if (f2) ans = Math.min(ans, dist / s[j]);
                    continue;
                }
                int t1 = -dx * sy[j] + dy * sx[j], t2 = -dx * sy[i] + dy * sx[i];
                if (detinv > 0 && (t1 < 0 || t2 < 0)) continue;
                if (detinv < 0 && (t1 > 0 || t2 > 0)) continue;
                double det = 1. / detinv;
                //System.out.printf("%d %d %f %f\n", i, j, det * t1, det * t2);
                ans = Math.min(ans, Math.max(t1 * len[i] * det, t2 * len[j] * det));
            }
        }
        if (ans == Double.POSITIVE_INFINITY) {
            out.ans("No show :(").ln();
        } else {
            out.ans(ans, 15).ln();
        }
    }
}
