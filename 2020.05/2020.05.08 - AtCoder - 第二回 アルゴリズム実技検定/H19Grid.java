package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class H19Grid {

    private static final int[] DX = {1, 0, -1, 0,};
    private static final int[] DY = {0, 1, 0, -1,};


    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        char[][] b = in.chars(n);
        int[][][] dist = new int[10][n][m];
        ArrayUtil.fill(dist, 1_000_000_000);
        int sx = -1, sy = -1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (b[i][j] == 'S') {
                    sx = j;
                    sy = i;
                }
        Queue<S> q = new ArrayDeque<>();
        q.offer(new S(sx, sy, 0));
        dist[0][sy][sx] = 0;
        while (!q.isEmpty()) {
            S s = q.poll();
            if (b[s.y][s.x] == 'G' && s.k == 9) {
                out.ans(dist[s.k][s.y][s.x]).ln();
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = s.x + DX[i], ny = s.y + DY[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                int nk = b[ny][nx] - '0' == s.k + 1 ? s.k + 1 : s.k;
                if (dist[nk][ny][nx] <= dist[s.k][s.y][s.x] + 1) continue;
                dist[nk][ny][nx] = dist[s.k][s.y][s.x] + 1;
                q.offer(new S(nx, ny, nk));
            }
        }
        out.ans(-1).ln();
    }

    private static class S {
        int x, y, k;

        S(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
}
