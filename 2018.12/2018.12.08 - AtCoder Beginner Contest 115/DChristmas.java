package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;

public class DChristmas {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long x = in.longs();
        long b = x;
        long ans = 0;
        for (int i = n; i >= 0; i--) {
            long h = height(i);
            long mid = (h + 1) / 2;
            if (b == mid) {
                ans += patties(i - 1);
                ans++;
                break;
            } else if (b == 1) {
                break;
            } else if (b == h) {
                ans += patties(i);
                break;
            } else if (b < mid) {
                b--;
            } else {
                ans += patties(i - 1);
                ans++;
                b -= mid;
            }
        }
        out.println(ans);
    }

    public long height(int n) {
        return (1L << (n + 2)) - 3;
    }

    public long patties(int n) {
        if (n < 0) {
            return 0;
        }
        return (1L << (n + 1)) - 1;
    }
}
