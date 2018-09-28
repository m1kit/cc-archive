package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CClosedRooms {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int h = in.nextInt(), w = in.nextInt(), k = in.nextInt();
        boolean[][] map = new boolean[h][];
        int sx = -1, sy = -1;
        for (int i = 0; i < h; i++) {
            map[i] = new boolean[w];
            String s = in.next();
            for (int j = 0; j < w; j++) {
                map[i][j] = s.charAt(j) == '#';
                if (s.charAt(j) == 'S') {
                    sx = j;
                    sy = i;
                }
            }
        }
        int md = Integer.MAX_VALUE;

        //LEFT
        int px = sx;
        for (int i = 0; i < k; i++) {
            px += -1;
            if (px < 0) {
                out.println(1);
                return;
            }
            if (map[sy][px]) {
                break;
            }
        }

    }
}
