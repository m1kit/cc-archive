package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ATravelingBudget {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(Math.min(in.nextInt(), in.nextInt()) + Math.min(in.nextInt(), in.nextInt()));
    }
}
