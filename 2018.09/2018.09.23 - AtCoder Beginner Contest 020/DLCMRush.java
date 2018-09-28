package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class DLCMRush {

    private static final int MOD = 1000000007;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        long ans = 0;
        for (int i = 1; i <= k; i++) {
            int a = n / k + (i <= n % k ? 1 : 0);
            long sum = (a * (long) (a + 1)) / 2;
            ans += (a * (i - k) + sum) * k / gcd(i, k);
            ans %= MOD;
            System.out.println(ans);
        }
        out.println(ans);
    }

    private static int gcd(int a, int b) {
        int t;
        while (a % b > 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return b;
    }
}
