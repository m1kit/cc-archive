package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class D1 {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int ans = 0;
        for (int i = 1; i <= 100000000; i *= 10) {
            if (n / i % 10 == 1) {
                ans += n % i + 1;
                // System.out.println(i + ": " + (n % i + 1));
            }
            ans += (n + 8 * i) / (10 * i) * i;
            // System.out.println(i + ": " + ((n + 8 * i) / (10 * i) * i));
        }
        out.println(ans);
    }
}
