package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int score = 10000000;
        for (int i = 1; i <= n; i++) {
            int h = n / i;
            int ns = Math.abs(h - i) + n - h * i;
            score = Math.min(ns, score);
        }
        out.println(score);
    }
}
