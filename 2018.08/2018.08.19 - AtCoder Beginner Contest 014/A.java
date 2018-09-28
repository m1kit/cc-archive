package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt();
        out.println(((a + b - 1) / b) * b - a);
    }
}
