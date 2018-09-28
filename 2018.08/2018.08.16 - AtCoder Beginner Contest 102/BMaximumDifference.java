package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BMaximumDifference {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        out.println(max - min);
    }
}
