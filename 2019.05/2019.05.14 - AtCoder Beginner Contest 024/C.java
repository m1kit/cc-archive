package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), d = in.ints(), k = in.ints();
        int[] l = new int[d], r = new int[d];
        in.ints(l, r);
        outer: for (int i = 0; i < k; i++) {
            int s = in.ints(), t = in.ints();
            for (int j = 0; j < d; j++) {
                if (s < l[j] || r[j] < s) continue;
                if (l[j] <= t && t <= r[j]) {
                    out.ans(j + 1).ln();
                    continue outer;
                } else if (s < t) {
                    s = r[j];
                } else {
                    s = l[j];
                }
            }
        }
    }
}
