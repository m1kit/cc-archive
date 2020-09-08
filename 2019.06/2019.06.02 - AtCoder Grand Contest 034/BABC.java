package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BABC {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string().replace("BC", "X");
        int n = s.length();
        long ans = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'A') {
                cnt++;
            } else if (s.charAt(i) == 'X') {
                ans += cnt;
            } else {
                cnt = 0;
            }
        }
        out.ans(ans).ln();
    }
}
