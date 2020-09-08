package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2d;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2l;

import java.util.ArrayList;
import java.util.List;

public class FEncloseAll {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        Vec2l[] ps = new Vec2l[n];
        for (int i = 0; i < n; i++) ps[i] = new Vec2l(in.longs(), in.longs());
        List<Vec2d> ms = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                ms.add(ps[i].add(ps[j]).mul(0.5));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    Vec2l x = ps[j].sub(ps[k]);
                    Vec2l y = ps[k].sub(ps[i]);
                    Vec2l z = ps[i].sub(ps[j]);
                    long a = x.lengthSquared();
                    long b = y.lengthSquared();
                    long c = z.lengthSquared();
                    if (x.det(y) == 0 || y.det(z) == 0 || z.det(x) == 0) continue;
                    ms.add(ps[i].mul(a * (b + c - a)).add(
                            ps[j].mul(b * (c + a - b))
                    ).add(
                            ps[k].mul(c * (a + b - c))
                    ).mul(1.0 / (a * (b + c - a) + b * (c + a - b) + c * (a + b - c))));
                }
            }
        }
        
        double ans = 1e20;
        for (Vec2d m : ms) {
            double r = 0.0;
            for (int l = 0; l < n; l++) {
                r = Math.max(r, ps[l].toVec2d().distanceTo(m));
            }
            ans = Math.min(ans, r);
        }
        out.ans(ans, 18).ln();
    }
}
