package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC087BCoins {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), x = in.nextInt();
        int ans = 0;
        for (int a0 = 0; a0 <= a; a0++) {
            for (int b0 = 0; b0 <= b; b0++) {
                for (int c0 = 0; c0 <= c; c0++) {
                    if (500 * a0 + 100 * b0 + 50 * c0 == x) {
                        ans++;
                    }
                }
            }
        }
        out.println(ans);
    }
}
