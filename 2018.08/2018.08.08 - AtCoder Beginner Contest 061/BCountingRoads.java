package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BCountingRoads {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int[] ans = new int[n];
        for (int i = 0; i < 2*m; i++) {
            ans[in.nextInt() - 1]++;
        }
        for (int a : ans) {
            out.println(a);
        }
    }
}
