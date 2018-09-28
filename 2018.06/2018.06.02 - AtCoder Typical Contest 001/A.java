package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class A {
    int h;
    int w;
    boolean[][] map;
    boolean[][] reachablitiy;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        h = in.nextInt();
        w = in.nextInt();
        int sx = 0, sy = 0, gx = 0, gy = 0;
        map = new boolean[h][];
        reachablitiy = new boolean[h][];
        for (int y = 0; y < h; y++) {
            map[y] = new boolean[w];
            reachablitiy[y] = new boolean[w];
            String s = in.next();
            for (int x = 0; x < w; x++) {
                char c = s.charAt(x);
                if (c == '#') {
                    map[y][x] = true;
                } else if (c == 's') {
                    sx = x;
                    sy = y;
                } else if (c == 'g') {
                    gx = x;
                    gy = y;
                }
            }
        }
        seek(sx, sy);
        out.println(reachablitiy[gy][gx] ? "Yes" : "No");
    }

    void seek(int x, int y) {
        if (reachablitiy[y][x]) {
            return;
        }
        if (!map[y][x]) {
            reachablitiy[y][x] = true;
        }
        if (x > 0 && !map[y][x - 1]) {
            seek(x - 1, y);
        }
        if (y > 0 && !map[y - 1][x]) {
            seek(x, y - 1);
        }
        if (x < w - 1 && !map[y][x + 1]) {
            seek(x + 1, y);
        }
        if (y < h - 1 && !map[y + 1][x]) {
            seek(x, y + 1);
        }
    }


}
