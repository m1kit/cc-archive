package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next().toLowerCase();
        out.println(s.substring(0, 1).toUpperCase() + s.substring(1));
    }
}
