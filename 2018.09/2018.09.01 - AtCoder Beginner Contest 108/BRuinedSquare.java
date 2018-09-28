package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BRuinedSquare {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int x1 = in.nextInt(), y1 = in.nextInt(), x2 = in.nextInt(), y2 = in.nextInt();
        for (int i = 0; i < 2; i++) {
            int x = x2 + (y1 - y2);
            int y = y2 + (x2 - x1);
            out.print(x);
            out.print(' ');
            out.print(y);
            out.print(' ');
            x1 = x2;
            y1 = y2;
            x2 = x;
            y2 = y;
        }
    }
}
