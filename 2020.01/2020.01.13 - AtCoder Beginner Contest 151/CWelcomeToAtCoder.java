package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CWelcomeToAtCoder {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        boolean[] ac = new boolean[n];
        int[] penalty = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int p = in.ints() - 1;
            if (ac[p]) {
                in.voids();
                continue;
            }
            if ("AC".equals(in.string())) {
                ac[p]=true;
                ans++;
            } else {
                penalty[p]++;
            }
        }
        int pen = 0;
        for (int i = 0; i < n; i++) {
            if (ac[i]) pen += penalty[i];
        }
        out.ans(ans).ans(pen).ln();
    }
}
