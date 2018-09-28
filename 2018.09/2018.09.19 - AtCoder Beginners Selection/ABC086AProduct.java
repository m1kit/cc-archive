package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC086AProduct {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(in.nextInt() * in.nextInt() % 2 == 0 ? "Even" : "Odd");
    }
}
