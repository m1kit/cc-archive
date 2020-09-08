package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BTwoCakes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int a = in.ints(), b = in.ints();
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(Math.min(a / i, b / (n - i)), ans);
        }
        out.ans(ans).ln();
    }
}
