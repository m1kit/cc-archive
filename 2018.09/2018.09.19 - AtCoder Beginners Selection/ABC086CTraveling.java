package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC086CTraveling {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = 0, x = 0, y = 0;
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int nt = in.nextInt(), nx = in.nextInt(), ny = in.nextInt();
            if (!canMove(nx - x, ny - y, nt - t)) {
                out.println("No");
                return;
            }
        }
        out.println("Yes");
    }

    public static boolean canMove(int x, int y, int t) {
        int d = t - Math.abs(x) - Math.abs(y);
        return d >= 0 && d % 2 == 0;
    }
}
