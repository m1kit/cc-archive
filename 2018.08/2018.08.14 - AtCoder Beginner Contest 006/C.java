package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int ans3 = 0;
        if (m % 2 == 1) {
            ans3 = 1;
            m -= 3;
            n -= 1;
        }
        int ans2 = 2 * n - (m / 2), ans4 = (m / 2) - n;
        if (ans2 < 0 || ans4 < 0) {
            out.println("-1 -1 -1");
        } else {
            out.print(ans2);
            out.print(' ');
            out.print(ans3);
            out.print(' ');
            out.println(ans4);
        }
    }
}
