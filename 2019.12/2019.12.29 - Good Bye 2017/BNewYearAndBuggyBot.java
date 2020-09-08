package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.counting.Permutation;

import java.util.Arrays;

public class BNewYearAndBuggyBot {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        char[][] b = new char[n][];
        for (int i = 0; i < n; i++)  b[i] = in.string().toCharArray();
        char[] s = in.string().toCharArray();
        int sx = -1, sy = -1;
        outer: for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (b[i][j] == 'S') {
                    sx = j;
                    sy = i;
                    break outer;
                }
            }
        }

        Direction[] directions = {
                new Direction(1, 0),
                new Direction(-1, 0),
                new Direction(0, 1),
                new Direction(0, -1),
        };
        Arrays.sort(directions);

        int ans = 0;
        while (directions != null) {
            main:
            {
                int x = sx, y = sy;
                for (char instr : s) {
                    int index = instr - '0';
                    int nx = x + directions[index].x, ny = y + directions[index].y;
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n || b[ny][nx] == '#') break main;
                    if (b[ny][nx] == 'E') {
                        ans++;
                        break main;
                    }
                    x = nx;
                    y = ny;
                }
            }
            directions = Permutation.nextPermutation(directions);
        }
        out.ans(ans).ln();
    }

    private static class Direction implements Comparable<Direction> {
        int x, y;

        public Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Direction o) {
            if (x == o.x) return Integer.compare(y, o.y);
            return Integer.compare(x, o.x);
        }
    }
}
