package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ATwoCoins {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(in.nextInt() + in.nextInt() >= in.nextInt() ? "Yes" : "No");
    }
}
