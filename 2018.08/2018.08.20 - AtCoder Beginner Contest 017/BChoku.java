package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BChoku {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(in.next().matches("^(?:ch|o|k|u)*$") ? "YES" : "NO");
    }
}
