package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CTogether {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int[] cnt = new int[100_001];
        int n = in.ints();
        for (int i = 0; i < n; i++) {
            cnt[in.ints()]++;
        }

        int ans = 0;
        for (int i = 1; i < 100_000; i++) {
            ans = Math.max(ans, cnt[i - 1] + cnt[i] + cnt[i + 1]);
        }
        out.ansln(ans);
    }
}
