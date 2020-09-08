package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class B {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        LocalDate now = LocalDate.parse(in.string(), formatter);
        while (now.getYear() % (now.getMonthValue() * now.getDayOfMonth()) != 0) now = now.plusDays(1);
        out.ans(formatter.format(now)).ln();
    }
}
