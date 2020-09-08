package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DRGBTriplets {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        char[] s = in.chars();
        long r = 0, g = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'R') r++;
            else if (s[i] == 'G') g++;
            else b++;
        }
        long ans = r * g * b;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; 2 * j - i < n; j++) {
                if (s[i] == s[j]) continue;
                if (s[i] == s[2 * j - i]) continue;
                if (s[j] == s[2 * j - i]) continue;
                ans--;
            }
        }
        out.ans(ans).ln();
    }
}
