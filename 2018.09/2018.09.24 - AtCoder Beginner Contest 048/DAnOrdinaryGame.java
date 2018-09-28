package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class DAnOrdinaryGame {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        out.println(s.charAt(0) == s.charAt(s.length() - 1) ^ s.length() % 2 == 1 ? "First" : "Second");
    }
}
