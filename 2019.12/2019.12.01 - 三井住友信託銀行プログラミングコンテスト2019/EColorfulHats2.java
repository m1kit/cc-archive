package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class EColorfulHats2 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int[] cnt = new int[3];
        long ans = 1;
        for (int i = 0; i < n; i++) {
            int pat = 0;
            for (int j = 0; j < 3; j++) if (cnt[j] == a[i]) pat++;
            ans *= pat;
            ans %= MOD;
            for (int j = 0; j < 3; j++)
                if (cnt[j] == a[i]) {
                    cnt[j]++;
                    break;
                }
        }
        out.ans(ans).ln();
    }
}
