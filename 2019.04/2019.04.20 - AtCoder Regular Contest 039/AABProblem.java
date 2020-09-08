package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AABProblem {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String a = in.string(), b = in.string();
        int ans = Integer.parseInt(a) - Integer.parseInt(b);
        for (int i = 0; i < 3; i++) {
            ans = Math.max(ans, Integer.parseInt(a.substring(0, i) + '9' + a.substring(i + 1)) - Integer.parseInt(b));
        }
        for (int i = 0; i < 3; i++) {
            ans = Math.max(ans, Integer.parseInt(a) - Integer.parseInt(b.substring(0, i) + (i == 0 ? '1' : '0') + b.substring(i + 1)));
        }
        out.ans(ans).ln();
    }
}
