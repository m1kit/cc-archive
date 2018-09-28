package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC085COtoshidama {

    private static final Pochibukuro[][] dp = new Pochibukuro[2001][20001];
    private static final Pochibukuro IMPOSSIBLE = new Pochibukuro(-1, -1, -1);

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        Pochibukuro p = calc(in.nextInt(), in.nextInt() / 1000);
        out.print(p.yukichi);
        out.print(' ');
        out.print(p.ichiyo);
        out.print(' ');
        out.println(p.soseki);
    }

    private static Pochibukuro calc(int n, int y) {
        if (n == 0 && y == 0) {
            return new Pochibukuro(0, 0, 0);
        } else if (n == 0 || y <= 0) {
            return IMPOSSIBLE;
        } else if (dp[n][y] != null) {
            return dp[n][y];
        }
        Pochibukuro p;
        if ((p = calc(n - 1, y - 10)) != IMPOSSIBLE) {
            return dp[n][y] = new Pochibukuro(p.yukichi + 1, p.ichiyo, p.soseki);
        } else if ((p = calc(n - 1, y - 5)) != IMPOSSIBLE) {
            return dp[n][y] = new Pochibukuro(p.yukichi, p.ichiyo + 1, p.soseki);
        } else if ((p = calc(n - 1, y - 1)) != IMPOSSIBLE) {
            return dp[n][y] = new Pochibukuro(p.yukichi, p.ichiyo, p.soseki + 1);
        } else {
            return dp[n][y] = IMPOSSIBLE;
        }
    }

    private static class Pochibukuro {
        private int yukichi, ichiyo, soseki;

        private Pochibukuro(int yukichi, int ichiyo, int soseki) {
            this.yukichi = yukichi;
            this.ichiyo = ichiyo;
            this.soseki = soseki;
        }
    }
}
