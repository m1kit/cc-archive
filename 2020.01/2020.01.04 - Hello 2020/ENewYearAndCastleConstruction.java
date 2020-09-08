package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2l;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ENewYearAndCastleConstruction {

    private static final double PI = 3.14159265358979323846338328;
    private static final double PI2 = PI * 2;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        Vec2l[] points = new Vec2l[n];
        for (int i = 0; i < n; i++) points[i] = new Vec2l(in.longs(), in.longs());
        long ans = n * (n - 1L) * (n - 2L) / 6;
        Arrays.sort(points, Vec2l::compareToByAngle);

        int hi = 0;
        for (int j = 0; j < n; j++) {
            while (hi < j + n && (hi <= j || points[j].det(points[hi % n]) >= 0)) {
                hi++;
            }
            int cnt = hi - j;
            ans -= cnt * (cnt - 1L) / 2;
        }

        out.ans(ans).ln();
    }

}
