package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CVacantSeat {

    private static final int MOD = (int) 1e9 + 7;

    private static boolean p(String token) {
        if ("Vacant".equals(token)) {
            System.exit(0);
        }
        return "Female".equals(token);
    }

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.enableAutoFlush();
        int n = in.ints();
        out.ans(0).ln();
        boolean x = p(in.string());
        out.ans(n - 1).ln();
        boolean y = p(in.string());
        int min = 0, max = n / 2;
        while (max - min > 1) {
            int mid = (min + max) / 2;
            out.ans(mid * 2).ln();
            boolean f = p(in.string());
            if (x == f) {
                min = mid;
            } else {
                max = mid;
            }
        }
        out.ans(2 * min + 1).ln();
    }
}
