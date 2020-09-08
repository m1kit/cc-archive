package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.GeoWalker;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.*;

public class BackInBusiness {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.POSSIBLE_IMPOSSIBLE_ALL_DOWN);
        int n = in.ints(), m = in.ints();
        String[] s = in.string(n);
        Entry start = null;
        int[][] d = new int[n][m];
        {
            for (int i = 0; i < n; i++) {
                int t = 3000;
                for (int j = 0; j < m; j++) {
                    t++;
                    if (s[i].charAt(j) == 'P') {
                        t = 0;
                    }
                    d[i][j] = t;
                }
                for (int j = m - 1; j >= 0; j--) {
                    t++;
                    t = Math.min(t, d[i][j]);
                    d[i][j] = t;
                }
            }
            for (int i = 0; i < m; i++) {
                int t = 3000;
                for (int j = 0; j < n; j++) {
                    t++;
                    t = Math.min(t, d[j][i]);
                    d[j][i] = t;
                }
                for (int j = n - 1; j >= 0; j--) {
                    t++;
                    t = Math.min(t, d[j][i]);
                    d[j][i] = t;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i].charAt(j) == '#') {
                    d[i][j] = -1;
                } else if (s[i].charAt(j) == 'S') {
                    start = new Entry(j, i, 0);
                }
            }
        }

        int min = 0, max = 2001;
        Queue<Entry> q = new ArrayDeque<>(n * m);
        boolean[][] visited = new boolean[n][m];
        outer:
        while (max - min > 1) {
            int mid = (min + max) / 2;
            q.clear();
            q.offer(start);
            ArrayUtil.fill(visited, false);

            while (!q.isEmpty()) {
                Entry e = q.poll();
                if (d[e.y][e.x] < mid || visited[e.y][e.x]) {
                    continue;
                } else if (s[e.y].charAt(e.x) == 'F') {
                    min = mid;
                    continue outer;
                }
                visited[e.y][e.x] = true;
                GeoWalker.forEach4i(e.x, e.y, (x, y) -> {
                    if (x < 0 || y < 0 || x >= m || y >= n || d[y][x] < mid || visited[y][x]) {
                        return;
                    }
                    q.offer(new Entry(x, y, 0));
                });
            }
            max = mid;
        }
        if (min == 0) {
            out.noln();
        } else {
            out.ans(min).ln();
        }
    }

    private static class Entry {
        int x, y, d;

        public Entry(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
