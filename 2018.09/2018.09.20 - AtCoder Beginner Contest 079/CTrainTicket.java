package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CTrainTicket {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int[] a = in.next().chars().map(i -> i - '0').toArray();
        for (int i = 0; i < 8; i++) {
            StringBuilder exp = new StringBuilder(Integer.toString(a[0]));
            int val = a[0];
            for (int j = 0; j < 3; j++) {
                exp.append((i & 1 << j) > 0 ? "+" : "-");
                exp.append(a[j + 1]);
                val += a[j + 1] * ((i & 1 << j) > 0 ? 1 : -1);
            }
            if (val == 7) {
                out.println(exp.append("=7"));
                return;
            }
        }
    }
}
