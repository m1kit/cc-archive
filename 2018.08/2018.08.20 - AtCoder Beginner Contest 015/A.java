package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String a = in.next(), b = in.next();
        if (a.length() > b.length()) {
            out.println(a);
        } else {
            out.println(b);
        }
    }
}
