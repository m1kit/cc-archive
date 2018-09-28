package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt();
        char[] s = in.next().toCharArray();
        if (a == 0) {
            out.println("Yes");
            return;
        }
        for (char c : s) {
            if (c == '+') {
                if (++a == 0) {
                    out.println("Yes");
                    return;
                }
            } else {
                if (--a == 0) {
                    out.println("Yes");
                    return;
                }
            }
        }
        out.println("No");
    }
}
