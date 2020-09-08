package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BFLIP {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints(), k = in.ints();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i * m + j * n - 2 * i * j == k) {
                    out.yesln();
                    return;
                }
            }
        }
        out.noln();
    }
}
