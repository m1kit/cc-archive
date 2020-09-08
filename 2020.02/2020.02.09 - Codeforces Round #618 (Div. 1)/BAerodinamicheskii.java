package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2l;

import java.util.HashSet;

public class BAerodinamicheskii {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        HashSet<Vec2l> ps = new HashSet<>();
        long gx = 0, gy = 0;
        long[] x = new long[n], y = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.longs();
            y[i] = in.longs();
            gx += x[i];
            gy += y[i];
            x[i] *= n;
            y[i] *= n;
            ps.add(new Vec2l(x[i], y[i]));
        }
        gx *= 2;
        gy *= 2;
        for (int i = 0; i < n; i++) {
            if (!ps.contains(new Vec2l(gx  - x[i], gy - y[i]))) {
                out.noln();
                return;
            }
        }
        out.yesln();
    }
}
