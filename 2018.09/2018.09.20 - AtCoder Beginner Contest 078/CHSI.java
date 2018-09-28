package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CHSI {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        out.println((1900 * m + 100 * (n - m)) * (1 << m));
    }
}
