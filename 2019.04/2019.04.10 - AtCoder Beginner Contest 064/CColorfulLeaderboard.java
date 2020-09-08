package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CColorfulLeaderboard {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int[] cnt = new int[9];
        for (int i = 0; i < n; i++) {
            cnt[Math.min(a[i] / 400, 8)]++;
        }
        int ans = 0;
        for (int i = 0; i < 8; i++) {
            if (cnt[i] > 0) {
                ans++;
            }
        }
        out.ans(Math.max(1, ans)).ans(ans + cnt[8]).ln();
    }
}
