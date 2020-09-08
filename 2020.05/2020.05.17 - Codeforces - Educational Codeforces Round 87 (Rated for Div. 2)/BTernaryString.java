package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class BTernaryString {

    private static final int INF = (int) 1e9;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            char[] s = in.chars();
            int n = s.length, ans = INF;
            int[] last = {-INF, -INF, -INF};
            for (int i = 0; i < n; i++) {
                last[s[i] - '1'] = i;
                ans = Math.min(ans, IntMath.max(last) - IntMath.min(last) + 1);
            }
            out.ans(ans >= INF ? 0 : ans).ln();
        }
    }
}
