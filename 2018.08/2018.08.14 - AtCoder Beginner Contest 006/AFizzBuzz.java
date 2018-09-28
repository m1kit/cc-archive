package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class AFizzBuzz {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(in.nextInt() % 3 == 0 ? "YES" : "NO");
    }
}
