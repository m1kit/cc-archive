package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BVaried {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        out.println(s.length() > s.chars().distinct().count() ? "no" : "yes");
    }
}
