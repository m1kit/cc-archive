package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        printRank(out, b, c, a);
        printRank(out, c, a, b);
        printRank(out, a, b, c);
    }

    private void printRank(PrintWriter out, int a, int b, int c) {
        if (c > a && c > b) {
            out.println(1);
        } else if (c > a || c > b) {
            out.println(2);
        } else {
            out.println(3);
        }
    }
}
