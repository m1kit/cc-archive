package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.GeoWalker;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2i;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Queue;

public class ADarkerAndDarker {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h = in.ints(), w = in.ints();
        int[][] res = new int[h][w];
        ArrayUtil.fill(res, 20000);

        Queue<Vec2i> q = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            String s = in.string();
            for (int j = 0; j < w; j++) {
                if (s.charAt(j) == '#') {
                    res[i][j] = 0;
                    q.add(new Vec2i(j, i));
                }
            }
        }
        while (!q.isEmpty()) {
            Vec2i v = q.poll();
            GeoWalker.forEach4i(v.x, v.y, (nx, ny) -> {
                if (nx < 0 || ny < 0 || nx >= w || ny >= h) return;
                if (res[v.y][v.x] + 1 >= res[ny][nx]) return;
                res[ny][nx] = res[v.y][v.x] + 1;
                q.offer(new Vec2i(nx, ny));
            });
        }

        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                ans = Math.max(ans, res[i][j]);
            }
        }
        out.ans(ans).ln();
    }
}
