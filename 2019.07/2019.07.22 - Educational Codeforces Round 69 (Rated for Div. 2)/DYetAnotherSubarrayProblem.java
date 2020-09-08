package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class DYetAnotherSubarrayProblem {

    private static final long INF = 300_000_000_000_001L;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        long k = in.longs();
        long[] a = in.longs(n);
        long[] sum = IntMath.sum(a);
        long ans = 0;
        long[] min = new long[m];
        Arrays.fill(min, INF);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, sum[i] - min[j]);
            }
            int pp = i % m;
            min[pp] = Math.min(min[pp], sum[i]) + k;
        }
        out.ans(ans).ln();
    }
}
