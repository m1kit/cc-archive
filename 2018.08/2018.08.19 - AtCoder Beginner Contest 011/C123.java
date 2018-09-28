package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.function.IntPredicate;

public class C123 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), count = 0;
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        IntPredicate ng = i -> i == a || i == b || i == c;
        if (ng.test(n)) {
            out.println("NO");
            return;
        }

        for (int i = 0; i < 100; i++) {
            if (!ng.test(n - 3)) {
                n -= 3;
            } else if (!ng.test(n - 2)) {
                n -= 2;
            } else if (!ng.test(n - 1)) {
                n -= 1;
            } else {
                out.println("NO");
                return;
            }
        }
        out.println(n > 0 ? "NO" : "YES");
    }
}
