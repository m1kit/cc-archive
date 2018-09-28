package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ACookieExchanges {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        if (a == b && b == c) {
            out.println(-1);
            return;
        }
        for (int i = 0;; i++) {
            if (a % 2 == 1 || b % 2 == 1) {
                out.println(i);
                return;
            }
            int na = (b + c) / 2, nb = (c + a) / 2, nc = (a + b) / 2;
            a = na;
            b = nb;
            c = nc;
        }
    }
}
