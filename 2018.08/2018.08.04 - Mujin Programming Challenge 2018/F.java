package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class F {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[in.nextInt()]++;
        }
        out.println(calc(a));
    }

    private static long calc(int[] num) {
        int i = 0;
        while (num[i] == 0) {
            if (++i == num.length) {
                return 1L;
            }
        }
        for (int n = 1; n <= i; i++) { // n人のチームを作りまーす

        }
        return 0;
    }
}
