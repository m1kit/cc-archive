package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BRingoSFavoriteNumbers {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int d = in.nextInt(), n = in.nextInt();
        int b = 1;
        for (int i = 0; i < d; i++) {
            b *= 100;
        }
        out.println(n == 100 ? b * (n + 1) : b * n);
    }
}
