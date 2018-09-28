package jp.llv.atcoder;

import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;

public class ADivideACuboid {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        out.println(a * b * c % 2 == 0 ? 0 : Math.min(a * b, Math.min(b * c, c * a)));
    }
}
