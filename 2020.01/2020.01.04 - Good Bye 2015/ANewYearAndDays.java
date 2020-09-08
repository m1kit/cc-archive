package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.time.LocalDate;

public class ANewYearAndDays {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int x = in.ints(), ans = 0;
        in.voids();
        String type = in.string();
        LocalDate day = LocalDate.of(2016, 1, 1);
        while (day.getYear() == 2016) {
            if ("week".equals(type)) {
                if (day.getDayOfWeek().getValue() == x) ans++;
            } else {
                if (day.getDayOfMonth() == x) ans++;
            }
            day = day.plusDays(1);
        }
        out.ans(ans).ln();
    }
}
