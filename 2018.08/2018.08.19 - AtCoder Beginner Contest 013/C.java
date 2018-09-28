package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), h = in.nextInt();
        long a = in.nextLong(), b = in.nextLong(), c = in.nextLong(), d = in.nextLong(), e = in.nextLong();

        long s = b + e, t = d + e, u = e * n - h;
        long ans = Long.MAX_VALUE;
        int y = 0;
        for (int x = n; x >= 0; x--) {
            while (s * x + t * y <= u) {
                y++;
            }
            if (x + y > n) {
                break;
            }
            ans = Math.min(ans, a * x + c * y);
        }
        out.println(ans);
    }
}
