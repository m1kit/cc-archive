package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int x1 = in.nextInt(), y1 = in.nextInt(), x2 = in.nextInt(), y2 = in.nextInt();
        int d = in.nextInt() * in.nextInt();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt(), y = in.nextInt();
            if (d >= Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1)) + Math.sqrt((x - x2) * (x - x2) + (y - y2) * (y - y2))) {
                out.println("YES");
                return;
            }
        }
        out.println("NO");
    }
}
