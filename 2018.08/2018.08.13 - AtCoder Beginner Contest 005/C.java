package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt(), n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int m = in.nextInt();
        int c = 0;
        for (int i = 0; i < m; i++) {
            if (c == n) {
                out.println("no");
                return;
            }

            int b = in.nextInt();
            while (a[c] + t < b || b < a[c]) {
                if (++c == n) {
                    out.println("no");
                    return;
                }
            }

            c++;
        }
        out.println("yes");
    }
}
