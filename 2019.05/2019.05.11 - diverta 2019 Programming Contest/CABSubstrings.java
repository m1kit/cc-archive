package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class CABSubstrings {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String[] s = in.string(n);
        long a = 0, b = 0, c = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int m = s[i].length();
            if (s[i].charAt(0) == 'B') b++;
            if (s[i].charAt(m - 1) == 'A') a++;
            if (s[i].charAt(0) == 'B' && s[i].charAt(m - 1) == 'A') c++;
            for (int j = 1; j < m; j++) {
                if (s[i].charAt(j - 1) == 'A' && s[i].charAt(j) == 'B') {
                    ans++;
                }
            }
        }
        if (a == b && b == c && a > 0) {
            ans += a - 1;
        } else {
            ans += Math.min(a, b);
        }
        out.ans(ans).ln();
    }
}
