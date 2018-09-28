package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class DGoodGrid {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), c = in.nextInt();
        int[][] count = {new int[c], new int[c], new int[c]};
        int[][] d = new int[c][];
        for (int i = 0; i < c; i++) {
            d[i] = new int[c];
        }
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                d[j][i] = in.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                count[(i + j) % 3][in.nextInt() - 1]++;
            }
        }
        int[][] cost = {new int[c], new int[c], new int[c]};
        for (int i = 0; i < c; i++) {
            cost[0][i] = dot(count[0], d[i]);
            cost[1][i] = dot(count[1], d[i]);
            cost[2][i] = dot(count[2], d[i]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < c; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    res = Math.min(cost[0][i] + cost[1][j] + cost[2][k], res);
                }
            }
        }
        out.println(res);
    }

    static int dot(int[] a1, int[] a2) {
        int r = 0;
        for (int i = 0; i < a1.length; i++) {
            r += a1[i] * a2[i];
        }
        return r;
    }
}
