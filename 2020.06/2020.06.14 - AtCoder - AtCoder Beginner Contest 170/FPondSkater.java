package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Queue;

public class FPondSkater {

    private static final int REP = 15;
    private static final int INF = 1_000_000_000;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int h = in.ints(), w = in.ints(), k = in.ints();
        int sy = in.ints() - 1, sx = in.ints() - 1, gy = in.ints() - 1, gx = in.ints() - 1;
        char[][] s = in.chars(h);
        int[][][] visited = new int[2][h][w];
        int[][] cost = new int[h][w];
        ArrayUtil.fill(cost, INF);
        cost[sy][sx] = 0;
        Queue<P> q = new ArrayDeque<>();
        q.offer(new P(sx, sy));
        while (!q.isEmpty()) {
            P now = q.poll();
            int[] rand = {0, 1, 2, 3};
            ArrayUtil.shuffle(rand);
            for (int r : rand) {
                switch (r) {
                    case 0:
                        if (visited[0][now.y][now.x] < REP) {
                            for (int d = 1; d <= k; d++) {
                                if (now.x - d < 0
                                        || s[now.y][now.x - d] == '@'
                                        || visited[0][now.y][now.x - d] >= REP) break;
                                if (d != k) visited[0][now.y][now.x - d]++;
                                if (cost[now.y][now.x - d] > cost[now.y][now.x] + 1) {
                                    cost[now.y][now.x - d] = cost[now.y][now.x] + 1;
                                }
                                q.offer(new P(now.x - d, now.y));
                            }
                        }
                        break;
                    case 1:
                        if (visited[0][now.y][now.x] < REP) {
                            for (int d = 1; d <= k; d++) {
                                if (w <= now.x + d
                                        || s[now.y][now.x + d] == '@'
                                        || visited[0][now.y][now.x + d] >= REP) break;
                                if (d != k) visited[0][now.y][now.x + d]++;
                                if (cost[now.y][now.x + d] > cost[now.y][now.x] + 1) {
                                    cost[now.y][now.x + d] = cost[now.y][now.x] + 1;
                                }
                                q.offer(new P(now.x + d, now.y));
                            }
                        }
                        break;
                    case 2:
                        if (visited[1][now.y][now.x] < REP) {
                            for (int d = 1; d <= k; d++) {
                                if (now.y - d < 0
                                        || s[now.y - d][now.x] == '@'
                                        || visited[1][now.y - d][now.x] >= REP) break;
                                if (d != k) visited[1][now.y - d][now.x]++;
                                if (cost[now.y - d][now.x] > cost[now.y][now.x] + 1) {
                                    cost[now.y - d][now.x] = cost[now.y][now.x] + 1;
                                }
                                q.offer(new P(now.x, now.y - d));
                            }
                        }
                        break;
                    case 3:
                        if (visited[1][now.y][now.x] < REP) {
                            for (int d = 1; d <= k; d++) {
                                if (h <= now.y + d
                                        || s[now.y + d][now.x] == '@'
                                        || visited[1][now.y + d][now.x] >= REP) break;
                                if (d != k) visited[1][now.y + d][now.x]++;
                                if (cost[now.y + d][now.x] > cost[now.y][now.x] + 1) {
                                    cost[now.y + d][now.x] = cost[now.y][now.x] + 1;
                                }
                                q.offer(new P(now.x, now.y + d));
                            }
                        }
                        break;
                }
            }
            visited[0][now.y][now.x]++;
            visited[1][now.y][now.x]++;
        }
        out.ans(cost[gy][gx] == INF ? -1 : cost[gy][gx]).ln();
    }

    private static class P {
        int x, y;

        P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
