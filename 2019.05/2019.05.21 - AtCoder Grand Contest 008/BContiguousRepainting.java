package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.stream.LongStream;

public class BContiguousRepainting {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        long[] a = in.longs(n);
        long[][] sum = new long[2][n + 1];
        for (int i = 0; i < n; i++) {
            sum[0][i + 1] = sum[0][i] + a[i];
            sum[1][i + 1] = sum[1][i] + Math.max(0, a[i]);
        }
        long ans = 0;
        for (int i = 0; i <= n - k; i++) {
            ans = Math.max(ans, Math.max(0, sum[0][i + k] - sum[0][i]) + (sum[1][n] - sum[1][i + k] + sum[1][i]));
        }
        out.ans(ans).ln();
    }
}
