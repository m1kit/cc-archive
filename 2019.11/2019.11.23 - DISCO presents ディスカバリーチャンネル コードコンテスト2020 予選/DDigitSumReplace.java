package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DDigitSumReplace {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int m = in.ints();
        int[] d = new int[m];
        long[] c = new long[m];
        long count = 0;
        long sum = 0;
        for (int i = 0; i < m; i++) {
            d[i] = in.ints();
            c[i] = in.longs();
            count += c[i];
            sum += d[i] * c[i];
        }
        long ans = count - 1 + (sum - 1) / 9;
        out.ans(ans).ln();
    }
}
