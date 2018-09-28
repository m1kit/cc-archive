package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CSkip {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int ans = Math.abs(in.nextInt() - x);
        for (int i = 1; i < n; i++) {
            ans = gcd(ans, Math.abs(in.nextInt() - x));
        }
        out.print(ans);
    }

    static int gcd(int u, int v) {
        int r;
        while (0 != v) {
            r = u % v;
            u = v;
            v = r;
        }
        return u;
    }
}
