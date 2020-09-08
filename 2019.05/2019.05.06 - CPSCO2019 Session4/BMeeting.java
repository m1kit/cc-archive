package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BMeeting {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), d = in.ints();
        String[] s = in.string(d);
        int ans = 0;
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < i; j++) {
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (s[i].charAt(k) == 'o' || s[j].charAt(k) == 'o') cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        out.ans(ans).ln();
    }
}
