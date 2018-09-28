package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int[][] q = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                q[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < Math.pow(n, k); i++) {
            int ans = 0;
            int c = i;
            for (int j = 0; j < n; j++) {
                ans ^= q[j][c % k];
                c /= k;
            }
            if (ans == 0) {
                out.println("Found");
                return;
            }
        }
        out.println("Nothing");
    }
}
