package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CXYZTriplets {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] ans = new int[10_002];
        for (int x = 1; x <= 100; x++) {
            for (int y = 1; y <= 100; y++) {
                for (int z = 1; z <= 100; z++) {
                    ans[Math.min(10_001, x * x + y * y + z * z + x * y + y * z + z * x)]++;
                }
            }
        }
        for (int i = 1; i <= n; i++) out.ans(ans[i]).ln();
    }
}
