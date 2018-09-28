package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ARatedForMe {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int r = in.nextInt();
        out.println(r < 1200 ? "ABC" : r < 2800 ? "ARC" : "AGC");
    }
}
