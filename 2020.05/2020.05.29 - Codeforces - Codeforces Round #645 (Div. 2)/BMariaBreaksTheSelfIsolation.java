package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BMariaBreaksTheSelfIsolation {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints();
            int[] sum = new int[n + 2];
            for (int i = 0; i < n; i++) sum[Math.min(n + 1, in.ints())]++;
            for (int i = 0; i <= n ; i++) sum[i + 1] += sum[i];
            for (int i = n; i >= 0; i--) {
                if (sum[i] >= i) {
                    out.ans(i + 1).ln();
                    break;
                }
            }
        }
    }
}
