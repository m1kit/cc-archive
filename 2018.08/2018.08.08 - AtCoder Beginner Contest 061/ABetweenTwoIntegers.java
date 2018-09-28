package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABetweenTwoIntegers {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        out.println(a <= c && c <= b ? "Yes" : "No");
    }
}
