package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class DWall {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int h = in.nextInt(), w = in.nextInt();
        int[][] c = new int[10][];
        for (int i = 0; i < 10; i++) {
            c[i] = IntStream.range(0, 10).map(x -> in.nextInt()).toArray();
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    c[j][k] = Math.min(c[j][k], c[j][i] + c[i][k]);
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < h * w; i++) {
            int a = in.nextInt();
            if (a >= 0) {
                ans += c[a][1];
            }
        }
        out.println(ans);
    }
}
