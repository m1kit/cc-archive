package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class CAlarmClocksEverywhere {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints(), m = in.ints();
        long[] x = in.longs(n), p = in.longs(m);
        long gcd = x[1] - x[0];
        for (int i = 2; i < n; i++) {
            gcd = IntMath.gcd(gcd, x[i] - x[i - 1]);
        }
        for (int i = 0; i < m; i++) {
            if (gcd % p[i] == 0) {
                out.yesln().ans(x[0]).ans(i + 1).ln();
                return;
            }
        }
        out.noln();
    }
}
