package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class G {

    private static final int D = 210;
    private final int[] DX = {1, 0, -1, 1, -1, 0};
    private final int[] DY = {1, 1, 1, 0, 0, -1};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), x = in.ints() + D, y = in.ints() + D;
        int[][] dist = new int[500][500];
        ArrayUtil.fill(dist, -1);
        dist[D][D] = 0;
        P origin = new P(D, D);
        Queue<P> q = new ArrayDeque<>();
        q.offer(origin);
        for (int i = 0; i < n; i++) dist[in.ints() + D][in.ints() + D] = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            P now = q.poll();
            int d = dist[now.x][now.y];
            if (now.x == x && now.y == y) {
                out.ans(d).ln();
                return;
            }
            for (int i = 0; i < 6; i++) {
                P next = new P(now.x + DX[i], now.y + DY[i]);
                if (next.x < 0 || next.y < 0 || next.x >= 500 || next.y >= 500 || dist[next.x][next.y] >= 0) continue;
                dist[next.x][next.y] = d + 1;
                q.offer(next);
            }
        }
        out.ans(-1).ln();
    }

    private static class P {
        int x, y;

        P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            P p = (P) o;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
