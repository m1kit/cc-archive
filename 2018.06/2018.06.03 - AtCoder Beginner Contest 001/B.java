package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int m = in.nextInt();
        if (m < 100) {
            out.println("00");
        } else if (m < 1000) {
            out.println("0" + (m / 100));
        } else if (m < 6000) {
            out.println(m / 100);
        } else if (m < 35000) {
            out.println(m / 1000 + 50);
        } else if (m <= 70000) {
            out.println((m / 1000 - 30) / 5 + 80);
        } else {
            out.println(89);
        }
    }
}
