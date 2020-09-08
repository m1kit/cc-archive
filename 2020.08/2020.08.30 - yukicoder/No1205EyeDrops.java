package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;

public class No1205EyeDrops {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints(), m = in.ints();
        long now = 0, pos = 0;
        for (int i = 0; i < m; i++) {
            long t = in.longs(), x = in.longs();
            if (Math.abs(x - pos) > t - now) {
                out.noln();
                return;
            }
            now = t;
            pos = x;
        }
        out.yesln();
    }
}
