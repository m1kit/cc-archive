package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class AGPA {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        double n = in.nextInt();
        out.println(in.next().chars().map(i -> Math.max(0, 'E' - i)).sum() / n);
    }
}
