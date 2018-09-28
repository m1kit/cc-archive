package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CShoppingStreet {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        boolean[][] f = new boolean[10][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < 10; i++) {
                f[i][j] = in.nextInt() == 1;
            }
        }
        int[][] p = new int[11][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= 10; i++) {
                p[i][j] = in.nextInt();
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < 0b1_00000_00000; i++) {
            int a = 0;
            for (int j = 0; j < n; j++) {
                int d = 0;
                for (int k = 0; k < 10; k++) {
                    if ((i & (1 << k)) > 0 && f[k][j]) {
                        d++;
                    }
                }
                a += p[d][j];
            }
            ans = Math.max(ans, a);
        }
        out.println(ans);
    }
}
