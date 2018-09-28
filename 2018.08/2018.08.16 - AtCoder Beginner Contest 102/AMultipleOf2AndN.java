package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class AMultipleOf2AndN {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        out.println(n % 2 == 0 ? n : n * 2);
    }
}
