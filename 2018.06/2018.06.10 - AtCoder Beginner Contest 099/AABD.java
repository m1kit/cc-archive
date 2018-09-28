package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class AABD {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        out.println(n < 1000 ? "ABC" : "ABD");
    }
}
