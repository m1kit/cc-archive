package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ARangeFlipFindRoute {

    private static final int INF = 1000000;

    private static final int[] DX = {0, 1};
    private static final int[] DY = {1, 0};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h = in.ints(), w = in.ints();
        char[][] s = in.chars(h);
        int[][] cost = new int[h][w];
        ArrayUtil.fill(cost, INF);
        cost[0][0] = s[0][0] == '#' ? 1 : 0;
        PriorityQueue<P> q = new PriorityQueue<>(Comparator.comparing(p -> cost[p.y][p.x]));
        q.offer(new P(0, 0));
        while (!q.isEmpty()) {
            P now = q.poll();
            for (int i = 0; i < 2; i++) {
                int ny = now.y + DY[i], nx = now.x + DX[i];
                if (ny < 0 || nx < 0 || h <= ny || w <= nx || cost[ny][nx] < INF) continue;
                int c;
                if (s[now.y][now.x] == s[ny][nx]) c = cost[now.y][now.x];
                else c = cost[now.y][now.x] + 1;
                if (c < cost[ny][nx]) {
                    cost[ny][nx] = c;
                    q.offer(new P(ny, nx));
                }
            }
        }
        /*for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.ans(cost[i][j]);
            }
            out.ln();
        }*/
        out.ans((cost[h - 1][w - 1] + 1) / 2).ln();
    }

    private static class P {
        int y, x;

        P(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
