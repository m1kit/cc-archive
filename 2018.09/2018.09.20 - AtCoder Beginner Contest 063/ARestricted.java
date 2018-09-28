package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ARestricted {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int s = in.nextInt() + in.nextInt();
        out.println(s >= 10 ? "error" : Integer.toString(s));
    }
}
