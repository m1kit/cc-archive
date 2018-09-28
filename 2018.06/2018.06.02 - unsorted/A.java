package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt(), n = in.nextInt();
        for (char c : in.next().toCharArray()) {
            if (c == 'S') {
                a--;
            } else if (c=='C') {
                b--;
            } else {
                if (a >= b) {
                    a--;
                } else {
                    b--;
                }
            }
        }
        out.println(a > 0 ? a : 0);
        out.println(b > 0 ? b : 0);
    }
}
