package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class C {
    int n, d, d2;
    int[] x;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        d = in.nextInt();
        d2 = d * 2;
        x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }

        int c1 = 0, c3 = 1, count = 0;
        for (int c2 = 1; c2 < n - 1; c2 ++) {
            int i = x[c2];
            while (i - x[c1] > d) {
                c1++;
            }
            if (c2 <= c1) {
                continue;
            }
            while (c3 != n - 1 && x[c3 + 1] - i <= d) {
                c3++;
            }
            if (c3 <= c2) {
                continue;
            }
            for (int c1i = c1; c1i < c2; c1i++) {
                int c1iv = x[c1i];
                for (int c3i = c3; c2 < c3i; c3i--) {
                    if (x[c3i] - c1iv > d) {
                        count++;
                    }
                }
            }
        }
        out.println(count);
    }
}
