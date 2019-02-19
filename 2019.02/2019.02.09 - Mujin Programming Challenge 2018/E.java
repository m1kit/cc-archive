package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.geo.Vec2i;
import jp.llv.atcoder.lib.geo.Vec3i;
import jp.llv.atcoder.lib.geo.Vec3l;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class E {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        try {
            int n = in.ints(), m = in.ints(), k = in.ints();
            String d = in.string();
            String[] b = in.string(n);

            Point start = null, goal = null;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (b[i].charAt(j) == 'S') {
                        start = new Point(i, j, 0);
                    } else if (b[i].charAt(j) == 'G') {
                        goal = new Point(i, j, -1);
                    }
                }
            }
            if (start == null || goal == null) {
                return;
            }

            int[][] dp = new int[4][2 * k + 1];
            String dd = d + d;
            for (int i = 0; i < 4; i++) {
                dp[i][2 * k] = -1;
            }
            for (int i = 2 * k - 1; i >= 0; i--) {
                for (int j = 0; j < 4; j++) {
                    if (dir(dd.charAt(i)) == j) {
                        dp[j][i] = 1;
                    } else if (dp[j][i + 1] == -1) {
                        dp[j][i] = -1;
                    } else {
                        dp[j][i] = dp[j][i + 1] + 1;
                    }
                }
            }

            long[][] dist = new long[n][m];
            ArrayUtil.fill(dist, -1);

            PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparing(p -> p.z));
            q.add(start);
            while (!q.isEmpty()) {
                Point orig = q.poll();
                if (dist[orig.x][orig.y] >= 0) {
                    continue;
                } else if (orig.x == goal.x && orig.y == goal.y) {
                    out.ans(orig.z).ln();
                    return;
                }
                dist[orig.x][orig.y] = orig.z;

                for (int i = 0; i < 4; i++) {
                    if (dp[i][(int) (orig.z % k)] == -1) {
                        continue;
                    }
                    Point dest = new Point(orig.x + DX[i], orig.y + DY[i], orig.z + dp[i][(int) (orig.z % k)]);
                    if (dest.x < 0 || dest.y < 0 || dest.x >= n || dest.y >= m || b[dest.x].charAt(dest.y) == '#') {
                        continue;
                    }
                    q.add(dest);
                }
            }
            out.ans(-1).ln();
        } catch(Error er) {}
    }

    private static class Point {
        int x, y;
        long z;

        public Point(int x, int y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    public static int dir(char c) {
        switch (c) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            case 'R':
                return 3;
        }
        return -1;
    }
}
