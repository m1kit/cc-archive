package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class AGrouping {
    private static final int[] GROUPS = {0, 1, 2, 1, 3, 1, 3, 1, 1, 3, 1, 3, 1};
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(GROUPS[in.nextInt()] == GROUPS[in.nextInt()] ? "Yes" : "No");
    }
}
