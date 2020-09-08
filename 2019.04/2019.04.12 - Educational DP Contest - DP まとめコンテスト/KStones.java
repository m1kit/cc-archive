package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class KStones {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.FIRST_SECOND_FIRST_UP);
        boolean[] ans = new boolean[100_001];
        int n = in.ints(), k = in.ints();
        int[] a = in.ints(n);
        for (int i = 0; i <= 100_000; i++) {
            if (ans[i]) continue;
            for (int j = 0; j < n && i + a[j] <= 100_000; j++) {
                ans[i + a[j]] = true;
            }
        }
        out.ans(ans[k]);
    }
}
