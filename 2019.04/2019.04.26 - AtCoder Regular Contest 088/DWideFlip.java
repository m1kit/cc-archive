package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DWideFlip {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int n = s.length();
        int ans = n;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                ans = Math.min(ans, Math.max(i,n - i));
            }
        }
        out.ans(ans).ln();
    }
}
