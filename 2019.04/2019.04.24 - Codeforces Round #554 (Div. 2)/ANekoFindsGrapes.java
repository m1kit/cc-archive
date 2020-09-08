package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ANekoFindsGrapes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int[]c = new int[2], d = new int[2];
        for (int i = 0; i < n; i++) {
            c[in.ints() % 2]++;
        }
        for (int i = 0; i < m; i++) {
            d[in.ints() % 2]++;
        }
        out.ans(Math.min(c[0], d[1]) + Math.min(c[1], d[0]));
    }
}
