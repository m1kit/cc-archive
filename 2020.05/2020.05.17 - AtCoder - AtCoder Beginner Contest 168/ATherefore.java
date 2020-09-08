package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ATherefore {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        switch (in.ints() % 10) {
            case 2:
            case 4:
            case 5:
            case 7:
            case 9:
                out.ans("hon").ln();
                break;
            case 0:
            case 1:
            case 6:
            case 8:
                out.ans("pon").ln();
                break;
            case 3:
                out.ans("bon").ln();
                break;
        }
    }
}
