package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AFeelTheBeat {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        long c = in.longs(), d = in.longs();
        long ans = 0;
        long lb = 140, ub = 170;
        while (lb <= 1_00000_00000_00000L) {
            ans += Math.max(0, Math.min(ub, d) - Math.max(lb, c));
            lb <<= 1;
            ub <<= 1;
        }
        out.ansln(ans);
    }
}
