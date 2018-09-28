package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class ACandyDistributionAgain {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        long x = in.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            x -= a[i];
            if (x == 0) {
                out.println(i + 1);
                return;
            } else if (x < 0) {
                out.println(i);
                return;
            }
        }
        if (x == 0) {
            out.println(n);
        } else {
            out.println(n - 1);
        }
    }
}
