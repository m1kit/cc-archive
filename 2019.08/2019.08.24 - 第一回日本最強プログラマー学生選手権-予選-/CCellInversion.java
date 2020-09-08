package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CCellInversion {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String s = in.string();
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
            ans %= MOD;
        }
        int open = 0;
        for (int i = 0; i < n * 2; i++) {
            if ((s.charAt(i) == 'W') == (open % 2 == 0)) {
                ans *= open;
                ans %= MOD;
                open--;
            } else {
                open++;
            }
        }
        out.ans(open == 0 ? ans : 0).ln();
    }
}
