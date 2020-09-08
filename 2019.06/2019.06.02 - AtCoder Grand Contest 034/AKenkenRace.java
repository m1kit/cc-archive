package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AKenkenRace {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), a = in.ints() - 1, b = in.ints() - 1, c = in.ints() - 1, d = in.ints() - 1;
        int min = b, max = d;
        String s = in.string() + "#######";
        if (c == d) {
            out.noln();
            return;
        }
        while (b < d) {
            if (s.charAt(b + 1) == '.') {
                b++;
            } else if (s.charAt(b + 2) == '.') {
                b += 2;
            } else {
                out.noln();
                return;
            }
        }
        while (a < c) {
            if (s.charAt(a + 1) == '.') {
                a++;
            } else if (s.charAt(a + 2) == '.') {
                a += 2;
            } else {
                out.noln();
                return;
            }
        }
        boolean cross = false;
        for (int i = Math.max(0, min - 1); i <= max - 1; i++) {
            if (s.charAt(i) == '.' && s.charAt(i + 1) == '.' && s.charAt(i + 2) == '.') {
                cross = true;
                break;
            }
        }
        out.ans(c < d || cross).ln();
    }
}
