package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AAngryStudents {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            char[] s = in.string().toCharArray();
            int ans = 0, last = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (s[i] == 'A') last = i;
                else ans = Math.max(ans, i - last);
            }
            out.ans(ans).ln();
        }
    }
}
