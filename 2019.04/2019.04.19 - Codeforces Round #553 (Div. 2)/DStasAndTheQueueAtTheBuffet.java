package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2i;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2l;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class DStasAndTheQueueAtTheBuffet {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP)
        int n = in.ints();
        Vec2l[] people = new Vec2l[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Vec2l(in.longs(), in.longs());
        }
        IntroSort.sort(people, Comparator.comparing(v -> -(v.x - v.y)));
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += people[i].x * i + people[i].y * (n - i - 1);
        }
        out.ansln(ans);
    }
}
