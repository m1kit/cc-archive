package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CHalfAndHalf {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), x = in.nextInt(), y = in.nextInt();
        int ans = 0;
        if (a + b > c * 2) {
            int ab = Math.min(x, y);
            ans += ab * c * 2;
            x -= ab;
            y -= ab;
        }
        if (a > c * 2) {
            ans += x * c * 2;
        } else {
            ans += x * a;
        }
        if (b > c * 2) {
            ans += y * c * 2;
        } else {
            ans += y * b;
        }
        out.println(ans);
    }
}
