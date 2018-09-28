package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt() + in.nextInt() + in.nextInt(), s = in.nextInt();
        out.println(a <= s && s <= a + 3 ? "Yes" : "No");
    }
}
