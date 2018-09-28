package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class B {
    private static final int MOD = 10007;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        if (n < 3) {
            out.println(0);
            return;
        }
        int a = 0, b = 0, c = 1;
        for (int i = 3; i < n; i++) {
            int t = (a + b + c) % MOD;
            a = b;
            b = c;
            c = t;
        }
        out.println(c % MOD);
    }
}
