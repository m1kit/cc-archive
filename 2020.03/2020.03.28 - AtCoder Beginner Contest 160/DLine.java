package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class DLine {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), x = in.ints(), y = in.ints();
        int[] ans = new int[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                ans[IntMath.min(Math.abs(i - j), Math.abs(i - x) + Math.abs(j - y) + 1, Math.abs(j - x) + Math.abs(i - y) + 1)]++;
            }
        }
        for (int i = 1; i < n; i++) out.ans(ans[i]).ln();
    }
}
