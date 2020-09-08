package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2i;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class DIntegerCards {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int[] a = in.ints(n);
        IntroSort.sort(a);
        Vec2i[] vs = new Vec2i[m + 1];
        for (int i = 0; i < m; i++) {
            vs[i] = new Vec2i(in.ints(), in.ints());
        }
        vs[m] = new Vec2i(100000, 0);
        IntroSort.sort(vs, Comparator.comparing(v -> -v.y));
        int cur = -1, rem = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (rem == 0) {
                cur++;
                rem = vs[cur].x;
            }
            if (vs[cur].y > a[i]) {
                //System.out.println("i="+i);
                rem--;
                ans += vs[cur].y;
            } else {
                ans += a[i];
            }
        }
        out.ans(ans).ln();
    }
}
