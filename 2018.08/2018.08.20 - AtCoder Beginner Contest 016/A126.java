package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class A126 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(in.nextInt() % in.nextInt() == 0 ? "YES" : "NO");
    }
}
