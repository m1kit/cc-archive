package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ASummerFestivalMeeting {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
        if (x == 0 || y == 0 || z == 0) {
            out.println(1);
        } else if (x == y || y == z || z == x) {
            out.println(2);
        } else if (x + y == 2 * z || y + z == 2 * x || z + x == 2 * y) {
            out.println(3);
        } else {
            out.println(-1);
        }
    }
}
