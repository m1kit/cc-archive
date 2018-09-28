package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class C {

    private static String[] data;
    private static int n;
    private static int m;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        data = new String[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.next();
        }
        int[][][] cache = new int[4][n][m];
        for (int y = 0; y < n; y++) {
            int value = 0;
            for (int x = 0; x < m; x++) {
                value = at(x, y) ? value + 1 : 0;
                cache[0][y][x] = value;
            }
        }
        for (int y = 0; y < n; y++) {
            int value = 0;
            for (int x = m - 1; x >= 0; x--) {
                value = at(x, y) ? value + 1 : 0;
                cache[2][y][x] = value;
            }
        }
        for (int x = 0; x < m; x++) {
            int value = 0;
            for (int y = 0; y < n; y++) {
                value = at(x, y) ? value + 1 : 0;
                cache[1][y][x] = value;
            }
        }
        for (int x = 0; x < m; x++) {
            int value = 0;
            for (int y = n - 1; y >= 0; y--) {
                value = at(x, y) ? value + 1 : 0;
                cache[3][y][x] = value;
            }
        }
        long ans = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (!at(x, y)) continue;
                for (int i = 0; i < 4; i++) {
                    ans += (cache[i % 4][y][x] - 1) * (cache[(i + 1) % 4][y][x] - 1);
                }
            }
        }
        out.println(ans);
    }

    private boolean at(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }
        return data[y].charAt(x) == '.';
    }
}
