package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CBruteForceAttack {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = (int) Math.pow(3, n);
        for (int i = 0; i < m; i++) {
            StringBuilder s = new StringBuilder();
            int t = i;
            for (int j = 0; j < n; j++) {
                s.insert(0, (char) (t % 3 + 'a'));
                t /= 3;
            }
            out.println(s);
        }
    }
}
