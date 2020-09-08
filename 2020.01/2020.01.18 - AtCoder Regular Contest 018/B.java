package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2l;

import java.util.Arrays;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), ans = 0;
        Vec2l[] vs = new Vec2l[n];
        for (int i = 0; i < n; i++) vs[i] = new Vec2l(in.longs(), in.longs());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    long det = Math.abs(vs[i].sub(vs[j]).det(vs[k].sub(vs[j])));
                    if (det != 0 && det % 2 == 0) ans++;
                }
            }
        }
        out.ans(ans).ln();
    }
}
