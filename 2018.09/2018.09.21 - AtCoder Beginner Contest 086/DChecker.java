package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class DChecker {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int[][] d = new int[2 * k + 1][2 * k + 1];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt(), y = in.nextInt();
            if (in.next().charAt(0) == 'W') {
                x += k;
            }
            x %= 2 * k;
            y %= 2 * k;
        }
    }
}
