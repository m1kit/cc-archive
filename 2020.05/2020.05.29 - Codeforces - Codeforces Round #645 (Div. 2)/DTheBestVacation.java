package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DTheBestVacation {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long x = in.longs();
        long[] d = in.longs(n);
        long sum = 0, hugs = 0, ans = 0;
        int month = 0, day = 0;
        for (int i = 0; i < 2 * n; i++) {
            int im = i % n;
            sum += d[im];
            hugs += d[im] * (d[im] + 1L) / 2;
            while (sum > x) {
                int mm = month % n;
                long dec = Math.min(sum - x, d[mm] - day);
                sum -= dec;
                hugs -= dec * (dec + 1) / 2 + day * dec;
                day += dec;
                if (day == d[mm]) {
                    day = 0;
                    month++;
                }
            }
            ans = Math.max(ans, hugs);
        }
        out.ans(ans).ln();
    }
}
