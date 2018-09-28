package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BStoneMonument {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt();
        long res = 0;
        for (int i = 1; i <= (b - a); i++) {
            res += i;
        }
        out.println(res - b);
    }
}
