package jp.llv.atcoder;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CAtCoder {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = in.nextInt();
        }
        Arrays.sort(r);
        double rate = 0;
        for (int i = n - k; i < n; i++) {
            rate = (rate + r[i]) / 2.0;
        }
        out.println(rate);
    }
}
