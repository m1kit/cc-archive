package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class JLeveling {

    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h = in.ints(), w = in.ints();
        int[][] c = in.ints(h, w);
        // ..2
        // ...
        // 0.1
        P[] start = {new P(0, h - 1), new P(w - 1, h - 1), new P(w - 1, 0)};
        int[][][] dist = new int[3][h][w];
        ArrayUtil.fill(dist, Integer.MAX_VALUE);
        for (int pos = 0; pos < 3; pos++) {
            int startPos = pos;
            PriorityQueue<P> q = new PriorityQueue<>(Comparator.comparing(p -> dist[startPos][p.y][p.x]));
            q.offer(start[pos]);
            dist[pos][start[pos].y][start[pos].x] = 0;

            while (!q.isEmpty()) {
                P p = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + DX[i], ny = p.y + DY[i];
                    if (nx < 0 || ny < 0 || nx >= w || ny >= h || dist[pos][ny][nx] <= dist[pos][p.y][p.x] + c[ny][nx]) continue;
                    dist[pos][ny][nx] = dist[pos][p.y][p.x] + c[ny][nx];
                    q.offer(new P(nx, ny));
                }
            }
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                ans = Math.min(ans, dist[0][i][j] + dist[1][i][j] + dist[2][i][j] - 2 * c[i][j]);
        out.ans(ans).ln();
    }

    private static class P {
        int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
