package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int all = 0;
        int[] dif = new int[m];
        for (int i = 0; i < n; i++) {
            int l = in.nextInt() - 1, r = in.nextInt() - 1, s = in.nextInt();
            all += s;
            dif[l] += s;
            if (r + 1 < m) {
                dif[r + 1] -= s;
            }
        }

        int min = dif[0];
        int sum = dif[0];
        for (int i = 1; i < m; i++) {
            min = Math.min(min, sum = sum + dif[i]);
        }

        out.println(all - min);
    }
}
