package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class AGoodInteger {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        int a = Integer.parseInt(s.substring(0, 3));
        int b = Integer.parseInt(s.substring(1, 4));
        out.println(a * b % 111 == 0 ? "Yes" : "No");
    }
}
