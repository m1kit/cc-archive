package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A2 {

    private static final long INF = 2_000_000_000_000L;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long a = in.longs(), k = in.longs();
        if (k == 0) {
            out.ans(INF - a).ln();
            return;
        }
        int ans = 0;
        while (a < INF) {
            ans++;
            a += 1 + k * a;
        }
        out.ans(ans).ln();
    }
}
