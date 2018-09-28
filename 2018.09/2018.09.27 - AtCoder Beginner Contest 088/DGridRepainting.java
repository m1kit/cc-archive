package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.io.PrintWriter;

public class DGridRepainting {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    private static String[] board;
    private static int[][] distance;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int h = in.ints(), w = in.ints();
        board = new String[h + 2];
        distance = new int[h + 2][w + 2];
        ArrayUtil.fill(distance, Integer.MAX_VALUE);
        distance[1][1] = 1;

        board[0] = "####################################################";
        board[h + 1] = "####################################################";
        int black = 0;
        for (int i = 1; i <= h; i++) {
            String s = in.string();
            black += s.chars().filter(c -> c == '#').count();
            board[i] = "#" + s + "#";
        }
        dfs(1, 1);
        if (distance[h][w] == Integer.MAX_VALUE) {
            out.println(-1);
        } else {
            out.println(h * w - black - distance[h][w]);
        }
    }

    public void dfs(int x, int y) {
        for (int i = 1; i <= 4; i++) {
            int nx = x + MVX[i];
            int ny = y + MVY[i];
            if (board[ny].charAt(nx) == '.' && distance[y][x] + 1 < distance[ny][nx]) {
                distance[ny][nx] = distance[y][x] + 1;
                dfs(nx, ny);
            }
        }
    }

}
