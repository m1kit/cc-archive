package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class APrefixes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        char[] s = in.string().toCharArray();
        int a = 0, ans = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s[2 * i] == 'a') a++;
            if (s[2 * i + 1] == 'a') a++;
            if (a > i + 1) {
                ans++;
                a--;
                if (s[2 * i] == 'a') {
                    s[2 * i] = 'b';
                } else if (s[2 * i + 1] == 'a') {
                    s[2 * i + 1] = 'b';
                }
            } else if (a < i + 1) {
                ans++;
                a++;
                if (s[2 * i] == 'b') {
                    s[2 * i] = 'a';
                } else if (s[2 * i + 1] == 'b') {
                    s[2 * i + 1] = 'a';
                }
            }
        }
        out.ans(ans).ln().ans(new String(s)).ln();

    }
}
