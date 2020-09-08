package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AEvenSubstrings {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        String s = in.string();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if ((s.charAt(i) - '0') % 2 == 0) {
                ans += i + 1;
            }
        }
        out.ans(ans);
    }
}
