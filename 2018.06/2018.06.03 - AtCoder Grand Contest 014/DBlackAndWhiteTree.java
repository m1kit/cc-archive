package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class DBlackAndWhiteTree {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] c = new int[n];
        int[] r = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt(), b = in.nextInt();
            c[a - 1]++;
            c[b - 1]++;
            r[a - 1] = b - 1;
            r[b - 1] = a - 1;
        }
        for (int i = 0; i < n; i++) {
            if (c[i] == 0) {
                out.println("First");
                return;
            } else if (c[i] == 1) {
                v[r[i]]++;
            }
        }
        for (int k : v) {
            if (k >= 2) {
                out.println("First");
                return;
            }
        }
        out.println("Second");
        Arrays.
    }
}
