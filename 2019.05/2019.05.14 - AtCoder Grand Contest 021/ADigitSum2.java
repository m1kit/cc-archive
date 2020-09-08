package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ADigitSum2 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        char[] s = in.string().toCharArray();
        int ans = ds(s);
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '0') continue;
            int c = s[i] - '1';
            c += (s.length - i - 1) * 9;
            ans = Math.max(c, ans);
        }
        out.ans(ans).ln();
    }

    private static int ds(char[] s) {
        int ans = 0;
        for (char c : s) {
            ans += c - '0';
        }
        return ans;
    }
}
