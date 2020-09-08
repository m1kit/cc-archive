package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;
import dev.mikit.atcoder.lib.util.function.BiIntConsumer;

public class F {

    private static final int INF = 100_000_000;
    private static final int[][] dist = new int[100][100];

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints();
        ArrayUtil.fill(dist, INF);
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (int q = 0; q < k; q++) {
            if (in.ints() == 0) {
                int x = in.ints() - 1, y = in.ints() - 1;
                int res = getDist(x, y);
                out.ans(res >= INF ? -1 : res).ln();
            } else {
                int x = in.ints() - 1, y = in.ints() - 1, c = in.ints();
                if (!setDist(x, y, c)) continue;
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        setDist(i, j, getDist(x, i) + c + getDist(j, y));
                        setDist(i, j, getDist(x, j) + c + getDist(i, y));
                    }
                }
            }
        }
    }

    private static int getDist(int x, int y) {
        return dist[x][y];
    }

    private static boolean setDist(int x, int y, int d) {
        if (dist[x][y] <= d) return false;
        dist[x][y] = dist[y][x] = d;
        return true;
    }
}
