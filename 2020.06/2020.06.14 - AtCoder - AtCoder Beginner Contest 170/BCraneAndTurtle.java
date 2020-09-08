package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BCraneAndTurtle {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int x = in.ints(), y = in.ints();
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (i + j == x && 2 * i + 4 * j == y) {
                    out.yesln();
                    return;
                }
            }
        }
        out.noln();
    }
}
