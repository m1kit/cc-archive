package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2i;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class DSnukesColoring {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long[] ans = new long[10];
        long h = in.longs(), w = in.longs();
        ans[0] = (h - 2L) * (w - 2L);
        int n = in.ints();
        Set<Vec2i> black = new HashSet<>();
        Set<Vec2i> q = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int y = in.ints() - 1, x = in.ints() - 1;
            black.add(new Vec2i(x, y));
            for (int j = y - 1; j <= y + 1; j++) {
                for (int k = x - 1; k <= x + 1; k++) {
                    if (k <= 0 || j <= 0 || k >= w - 1 || j >= h - 1) continue;
                    q.add(new Vec2i(k, j));
                }
            }
        }

        //System.out.println(q);
        Queue<Vec2i> qu = new ArrayDeque<>(q);

        while (!qu.isEmpty()) {
            Vec2i t = qu.poll();
            int c = 0;
            for (int i = t.y - 1; i <= t.y + 1; i++) {
                for (int j = t.x - 1; j <= t.x + 1; j++) {
                    if (black.contains(new Vec2i(j, i))) {
                        c++;
                    }
                }
            }
            ans[0]--;
            ans[c]++;
        }

        out.ansln(ans);
    }
}
