package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2l;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;

public class FEngines {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        Vec2l[] engines = new Vec2l[n];
        for (int i = 0; i < n; i++) engines[i] = new Vec2l(in.longs(), in.longs());
        Arrays.sort(engines, Vec2l::compareToByAngle);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long x = 0, y = 0;
            for (int j = 0; j < n; j++) {
                x += engines[(i + j) % n].x;
                y += engines[(i + j) % n].y;
                ans = Math.max(ans, x * x + y * y);
            }
        }
        out.ans(Math.sqrt(ans), 20).ln();
    }
}
