package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BLucasNumber {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long[] r = new long[87];
        r[0] = 2;
        r[1] = 1;
        for (int i = 2; i < 87; i++) {
            r[i] = r[i - 2] + r[i - 1];
        }
        out.println(r[in.nextInt()]);
    }
}
