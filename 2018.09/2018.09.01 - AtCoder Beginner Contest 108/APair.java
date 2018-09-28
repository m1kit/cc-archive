package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class APair {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int i = in.nextInt();
        int e = i / 2, o = (i + 1) / 2;
        out.println(e * o);
    }
}
