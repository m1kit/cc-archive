package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ATakahashiCalendar {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int m = in.ints(), d = in.ints();
        int ans = 0;
        for (int month = 1; month <= m; month++) {
            for (int day = 1; day <= d; day++) {
                int d1 = day  % 10, d2 = day / 10;
                if (d1 >= 2 && d2 >= 2 && d1 * d2 == month) ans++;
            }
        }
        out.ans(ans).ln();
    }
}
