package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class APoweredAddition {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        // out.setCaseLabel(LightWriter.CaseLabel.NONE);
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints();
            long[] a = in.longs(n);
            for (int i = 0;; i++) {
                long d = (1L << i) - 1;
                boolean ok = true;
                long last = a[0];
                for (int j = 1; j < n; j++) {
                    if (last > a[j] + d) {
                        ok = false;
                        break;
                    } else last = Math.max(last, a[j]);
                }
                if (ok) {
                    out.ans(i).ln();
                    break;
                }
            }
        }
    }
}
