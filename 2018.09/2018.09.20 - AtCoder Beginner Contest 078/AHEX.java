package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class AHEX {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        char x = in.next().charAt(0), y = in.next().charAt(0);
        if (x == y) {
            out.println("=");
        } else if (x > y) {
            out.println(">");
        } else {
            out.println("<");
        }
    }
}
