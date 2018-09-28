package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int m = 2025 - in.nextInt();
        for (int i = 1; i <= 9; i++) {
            if (m % i == 0 && m / i <= 9) {
                out.println(i + " x " + (m / i));
            }
        }
    }
}
