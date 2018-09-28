package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt();
        out.println(Math.min(Math.min(Math.abs(a - b), Math.abs(a - b + 10)), Math.abs(a - b - 10)));
    }
}
