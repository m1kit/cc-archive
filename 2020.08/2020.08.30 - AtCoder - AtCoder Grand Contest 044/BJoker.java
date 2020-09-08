package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BJoker {

    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        // 01 02 03 04
        // 05 06 07 08
        // 09 10 11 12
        // 13 14 15 16
        int n = in.ints();
        int[] a = in.ints(n * n);
        int[][] dist = new int[n][n];
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Math.min(Math.min(i + 1, j + 1), Math.min(n - i, n - j));
                cost[i][j] = 1;
            }
        }
        int ans = 0;
        Queue<P> q = new ArrayDeque<>(n);
        for (int i = 0; i < n * n; i++) {
            a[i]--;
            int sx = a[i] / n, sy = a[i] % n;
            dist[sx][sy]--;
            cost[sx][sy] = 0;
            q.offer(new P(sx, sy));
            while (!q.isEmpty()) {
                P p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + DX[j], ny = p.y + DY[j];
                    if (nx < 0 || ny < 0 || n <= nx || n <= ny) continue;
                    if (dist[p.x][p.y] + cost[nx][ny] >= dist[nx][ny]) continue;
                    dist[nx][ny] = dist[p.x][p.y] + cost[nx][ny];
                    q.offer(new P(nx, ny));
                }
            }
            ans += dist[sx][sy];
        }
        out.ans(ans).ln();
    }

    private static class P {
        int x, y;

        P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
