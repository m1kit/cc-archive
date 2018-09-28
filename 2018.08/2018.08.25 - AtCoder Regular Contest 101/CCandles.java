package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CCandles {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[n - i - 1] = -x[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            ans = Math.min(ans, x[i + k - 1] - x[i] + Math.abs(x[i]));
            ans = Math.min(ans, y[i + k - 1] - y[i] + Math.abs(y[i]));
        }
        out.println(ans);
    }
}
