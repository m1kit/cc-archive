package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CAttackSurvival {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints(), q = in.ints();
        int[] cnt = new int[n];
        for (int i = 0; i < q; i++) {
            cnt[in.ints() - 1]++;
        }
        for (int i = 0; i < n; i++) {
            out.ans(q - cnt[i] < k).ln();
        }
    }
}
