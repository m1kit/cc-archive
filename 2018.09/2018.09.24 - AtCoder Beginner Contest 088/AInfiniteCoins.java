package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class AInfiniteCoins {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(in.nextInt() % 500 <= in.nextInt() ? "Yes" : "No");
    }
}
