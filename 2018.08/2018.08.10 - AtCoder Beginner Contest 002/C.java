package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int x = in.nextInt(), y = in.nextInt();
        int x1 = in.nextInt() - x, y1 = in.nextInt() - y;
        int x2 = in.nextInt() - x, y2 = in.nextInt() - y;
        out.println(Math.abs(x1 * y2 - x2* y1) / 2.0);
    }
}
