package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DWizardInMaze {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int h = in.ints(), w = in.ints();
        int sy = in.ints() - 1, sx = in.ints() - 1;
        int gy = in.ints() - 1, gx = in.ints() - 1;
        char[][] s = in.chars(h);
        int[][] d = new int[h][w];
        ArrayUtil.fill(d, h * w);
        d[sy][sx] = 0;
        PriorityQueue<P> q = new PriorityQueue<>(Comparator.comparing(p -> d[p.y][p.x]));
        q.offer(new P(sx, sy));
        while (!q.isEmpty()) {
            P p = q.poll();
            for (int dx = -2; dx <= 2; dx++) {
                int nx = p.x + dx;
                if (nx < 0 || w <= nx) continue;
                for (int dy = -2; dy <= 2; dy++) {
                    if (dx == 0 && dy == 0) continue;
                    int ny  = p.y + dy;
                    if (ny < 0 || h <= ny || s[ny][nx] == '#') continue;
                    int c = Math.abs(dx) + Math.abs(dy) == 1 ? 0 : 1;
                    if (d[ny][nx] <= d[p.y][p.x] + c) continue;
                    d[ny][nx] = d[p.y][p.x] + c;
                    q.offer(new P(nx, ny));
                }
            }
        }
        if (d[gy][gx] >= h * w) out.ans(-1).ln();
        else out.ans(d[gy][gx]).ln();
    }

    private static class P {
        int x, y;

        P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
