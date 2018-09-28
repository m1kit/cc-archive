package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BABProblem {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        if (b == 0 && a == c) {
            out.println("?");
        } else if (a + b == c) {
            out.println("+");
        } else if (a - b == c) {
            out.println("-");
        } else {
            out.println("!");
        }
    }
}
