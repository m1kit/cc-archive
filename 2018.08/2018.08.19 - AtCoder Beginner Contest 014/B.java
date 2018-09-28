package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), x = in.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            if (x % 2 == 1) {
                sum += a;
            }
            x /= 2;
        }
        out.println(sum);
    }
}
