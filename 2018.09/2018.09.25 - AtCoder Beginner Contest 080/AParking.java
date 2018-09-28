package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class AParking {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(Math.min(in.nextInt() * in.nextInt(), in.nextInt()));
    }
}
