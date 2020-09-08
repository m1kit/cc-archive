package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class BColorfulHats {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int max = IntMath.max(a), min = IntMath.min(a);
        if (max - min > 1) {
            out.noln();
            return;
        } else if (max == min) {
            out.ans(min * 2 <= n || min == n - 1).ln();
            return;
        }
        int uniq = 0;
        for (int i = 0; i < n; i++) if (a[i] == min) uniq++;
        int s = max - uniq, t = n - uniq;
        out.ans(uniq + 1 <= max && s * 2 <= t).ln();
    }
}
