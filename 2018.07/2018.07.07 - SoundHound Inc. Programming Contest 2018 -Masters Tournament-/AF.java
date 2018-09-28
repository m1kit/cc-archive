package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class AF {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt();
        if (a * b == 15) {
            out.println("*");
        } else if (a + b == 15) {
            out.println("+");
        } else {
            out.println("x");
        }
    }
}
