package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int s = n % 60;
        n /= 60;
        int m = n % 60;
        int h = n / 60;
        out.printf("%02d:%02d:%02d", h, m, s);
    }
}
