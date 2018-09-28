package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class DInsertion {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        String s = in.next();
        int pre = 0;
        int open = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (open == 0) {
                    pre++;
                } else {
                    open--;
                }
            }
        }
        for (int i = 0; i < pre; i++) {
            out.print('(');
        }
        out.print(s);
        for (int i = 0; i < open; i++) {
            out.print(')');
        }
        out.println();
    }
}
