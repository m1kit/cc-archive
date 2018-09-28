package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BHarshadNumber {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), t = n;
        int f = 0;
        while (t > 0) {
            f += t % 10;
            t /= 10;
        }
        out.println(n % f == 0 ? YES : NO);
    }
}
