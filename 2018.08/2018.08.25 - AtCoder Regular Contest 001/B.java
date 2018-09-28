package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int d = Math.abs(in.nextInt() - in.nextInt());
        int c = 0;
        while (d > 0) {
            if (d >= 8) {
                c++;
                d -= 10;
                d = Math.abs(d);
            } else if (d >= 4) {
                c++;
                d -= 5;
                d = Math.abs(d);
            } else {
                c += d;
                d = 0;
            }
        }
        out.println(c);
    }
}
