package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Queue;

public class C {

    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int h = in.ints(), w = in.ints(), t = in.ints();
        char[][] s = new char[h][];
        int sx = 0, sy = 0, gx = 0, gy = 0;
        for (int i = 0; i < h; i++) {
            s[i] = in.string().toCharArray();
            for (int j = 0; j < w; j++) {
                if (s[i][j] == 'S') {
                    sx = j;
                    sy = i;
                } else if (s[i][j] == 'G') {
                    gx = j;
                    gy = i;
                }
            }
        }
        long min = 1, max = 2_000_000_000L;
        while (max - min > 1) {
            long mid = (min + max) / 2;
            long[][] c = new long[h][w];
            boolean[][] visited = new boolean[h][w];
            ArrayUtil.fill(c, 1_000_000_000_000L);
            c[sy][sx] = 0;
            Queue<Node> q = new ArrayDeque<>();
            q.offer(new Node(sx, sy));
            while (!q.isEmpty()) {
                Node node = q.poll();
                if (visited[node.y][node.x]) continue;
                visited[node.y][node.x] = true;
                for (int i = 0; i < 4; i++) {
                    int nx = node.x + DX[i], ny = node.y + DY[i];
                    if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
                    long cost = s[ny][nx] == '#' ? mid : 1;
                    if (c[ny][nx] <= c[node.y][node.x] + cost) continue;
                    c[ny][nx] = c[node.y][node.x] + cost;
                    q.offer(new Node(nx, ny));
                }
            }
            if (c[gy][gx] <= t) min = mid;
            else max = mid;
        }
        out.ans(min).ln();
    }

    private static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
