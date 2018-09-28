package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC083BSomeSums {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), a = in.nextInt(), b = in.nextInt();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0, d = i;
            while (d > 0) {
                sum += d % 10;
                d /= 10;
            }
            if (a <= sum && sum <= b) {
                ans += i;
            }
        }
        out.println(ans);
    }
}
