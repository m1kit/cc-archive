package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class DAlmostDifference {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n);
        long sum = 0;
        BigInteger ans = BigInteger.ZERO;

        Map<Long, Long> near = new HashMap<>();
        Map<Long, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long k = near.getOrDefault(a[i], 0L);
            int c = count.getOrDefault(a[i], 0);
            ans = ans.add(BigInteger.valueOf(a[i] * (i - c) - (sum - k)));

            sum += a[i];

            count.merge(a[i] - 1, 1, Integer::sum);
            count.merge(a[i], 1, Integer::sum);
            count.merge(a[i] + 1, 1, Integer::sum);

            near.merge(a[i] - 1, a[i], Long::sum);
            near.merge(a[i], a[i], Long::sum);
            near.merge(a[i] + 1, a[i], Long::sum);
        }
        out.ans(ans).ln();
    }
}
