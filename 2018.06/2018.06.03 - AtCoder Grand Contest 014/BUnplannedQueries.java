package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BUnplannedQueries {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int[] f = new int[n];
        for (int i = 0; i < m; i++) {
            f[in.nextInt() - 1]++;
            f[in.nextInt() - 1]++;
        }
        for (int i : f) {
            if (i % 2 != 0) {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
    }
}
