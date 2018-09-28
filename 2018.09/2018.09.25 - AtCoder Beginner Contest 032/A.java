package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class A {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int lcm = lcm(in.nextInt(), in.nextInt());
        out.println((in.nextInt() + lcm - 1) / lcm * lcm);
    }

    private static int lcm(int a, int b) {
        long ans = a * b;
        ans /= gcd(a, b);
        return (int) ans;
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
