package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CDiceAndCoin {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        double ans = 0;
        for (int i = 1; i <= n; i++) {
            int init = i;
            int cnt = 0;
            while (init < k) {
                init *= 2;
                cnt++;
            }
            ans += Math.pow(2, -cnt);
        }
        ans /= n;
        out.ans(ans, 12).ln();
    }
}
