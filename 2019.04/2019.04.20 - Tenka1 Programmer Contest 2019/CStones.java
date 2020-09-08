package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CStones {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String s = in.string();
        int[] white = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '.') {
                white[i + 1] = white[i] + 1;
            } else {
                white[i + 1] = white[i];
            }
        }

        int ans = n + 1;
        for (int i = 0; i <= n; i++) {
            int btw = i - white[i];
            int wtb = white[n] - white[i];
            ans = Math.min(ans, btw + wtb);
        }
        out.ans(ans).ln();
    }
}
