package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] c = new int[n];
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }

        for (int i= 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && c[i] % c[j] == 0) {
                    s[i]++;
                }
            }
        }

        double ans = 0;
        for (int i = 0; i < n; i++) {
            ans += s[i] % 2 == 0 ? (s[i] + 2.0) / (2 * s[i] + 2.0) : 0.5;
        }
        out.println(ans);
    }
}
