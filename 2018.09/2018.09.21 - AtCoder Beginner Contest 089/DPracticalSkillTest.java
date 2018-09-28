package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.io.PrintWriter;

public class DPracticalSkillTest {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int h = in.nextInt(), w = in.nextInt(), hw = h * w;
        int d = in.nextInt();
        int s = (hw + d - 1) / d;
        int[][] xs = new int[d][s];
        int[][] ys = new int[d][s];
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int a = in.nextInt() - 1;
                xs[a % d][a / d] = x;
                ys[a % d][a / d] = y;
            }
        }
        int[][] sum = new int[d][s];
        for (int i = 0; i < d; i++) {
            for (int j = 1; j < s; j++) {
                sum[i][j] = sum[i][j - 1]
                        + Math.abs(xs[i][j - 1] - xs[i][j])
                        + Math.abs(ys[i][j - 1] - ys[i][j]);
            }
        }
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int l = in.nextInt() - 1, r = in.nextInt() - 1;
            int m = l % d;
            l /= d;
            r /= d;
            out.println(sum[m][r] - sum[m][l]);
        }
    }
}
