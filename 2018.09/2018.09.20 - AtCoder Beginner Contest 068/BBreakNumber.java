package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BBreakNumber {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println((int) Math.pow(2, Math.floor(Math.log(in.nextInt()) / Math.log(2))));
    }
}
