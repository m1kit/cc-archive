package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2l;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class BCollectingPackages {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            Vec2l[] vs = new Vec2l[n];
            for (int i = 0; i < n; i++) vs[i] = new Vec2l(in.longs(), in.longs());
            IntroSort.sort(vs);
            boolean ok = true;
            for (int i = 1; i < n; i++) ok &= vs[i - 1].x <= vs[i].x && vs[i - 1].y <= vs[i].y;
            out.ans(ok).ln();
            if (!ok) continue;
            int x = 0, y = 0;
            for (int i = 0; i < n; i++) {
                while (x < vs[i].x) {
                    out.print('R');
                    x++;
                }
                while (y < vs[i].y) {
                    out.print('U');
                    y++;
                }
            }
            out.ln();
        }
    }
}
