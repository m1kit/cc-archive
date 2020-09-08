package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BCountABC {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), ans = 0;
        String s = in.string();
        for (int i = 0; i < n - 2; i++) {
            if ("ABC".equals(s.substring(i, i + 3))) ans++;
        }
        out.ans(ans).ln();
    }
}
