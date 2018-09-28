package jp.llv.atcoder;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), d = in.nextInt();
        int x = Math.abs(in.nextInt()), y = Math.abs(in.nextInt());
        if (x % d != 0 || y % d != 0) {//ぴったり止まりません
            out.println(0.0);
            return;
        }
        x /= d;
        y /= d;

        double[][] comb = new double[1001][];
        comb[0] = new double[]{1.0};
        for (int i = 1; i <= 1000; i++) {
            comb[i] = new double[i + 1];
            comb[i][0] = comb[i][i] = comb[i - 1][0] / 2.0;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) / 2.0;
            }
        }

        double ans = 0.0;
        for (int i = 0; i <= n; i++) {
            //System.out.println("THIS IS "+i);
            //System.out.println("x dir: "+(i - x));
            //System.out.println("y dir: "+(n - i - y));
            if (x <= i && y <= (n - i) && (i - x) % 2 == 0 && (n - i - y) % 2 == 0) {
                //System.out.println("==MATCH==");
                ans += comb[n][i] * comb[i][(i + x) / 2] * comb[n - i][(n - i + y) / 2];
            }
        }
        out.println(ans);
    }
}
