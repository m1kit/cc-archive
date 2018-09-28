package jp.llv.atcoder;

import java.util.*;
import java.io.PrintWriter;

public class C {
    private final static Pair[] DIRS = {
            new Pair(1, 0),
            new Pair(0, 1),
            new Pair(-1, 0),
            new Pair(0, -1),
    };

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int h = in.nextInt(), w = in.nextInt();
        int sy = in.nextInt() - 1, sx = in.nextInt() - 1;
        int gy = in.nextInt() - 1, gx = in.nextInt() - 1;
        String[] b = new String[h];
        int[][] d = new int[w][h];
        for (int i = 0; i < h; i++) {
            b[i] = in.next();
            for (int j = 0; j < w; j++) {
                d[j][i] = Integer.MAX_VALUE;
            }
        }
        d[sx][sy] = 0;

        Queue<Pair> q = new PriorityQueue<>(Comparator.comparing(p -> d[p.x][p.y]));
        q.add(new Pair(sx, sy));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (Pair v : DIRS) {
                Pair n = new Pair(p.x + v.x, p.y + v.y);
                if (b[n.y].charAt(n.x) == '#' || d[n.x][n.y] < Integer.MAX_VALUE) {
                    continue;
                }
                d[n.x][n.y] = d[p.x][p.y] + 1;
                q.add(n);
            }
        }
        //System.out.println(Arrays.deepToString(d));
        out.println(d[gx][gy]);
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
