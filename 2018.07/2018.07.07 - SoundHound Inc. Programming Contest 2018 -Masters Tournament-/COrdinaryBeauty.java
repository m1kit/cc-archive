package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class COrdinaryBeauty {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long n = in.nextLong(), m = in.nextLong(), d = in.nextLong();
        if (d == 0) {
            out.printf("%.10f", (m - 1) / (double) n);
        } else {
            out.printf("%.10f", 2 * (n - d) * (m - 1) / (double) (n * n));
        }
    }
}
