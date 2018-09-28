package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CTravelingPlan {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] x = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            x[i] = in.nextInt();
        }
        long sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += Math.abs(x[i] - x[i + 1]);
        }

        for (int i = 1; i <= n; i++) {
            out.println(sum - Math.abs(x[i] - x[i - 1]) - Math.abs(x[i + 1] - x[i]) + Math.abs(x[i + 1] - x[i - 1]));
        }
    }
}
