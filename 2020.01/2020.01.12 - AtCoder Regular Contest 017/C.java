package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashMap;
import java.util.Map;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), lo = Math.min(16, n), hi = Math.max(0, n - 16);
        long x = in.longs(), ans = 0;
        long[] w = in.longs(n);
        Map<Long, Long> cnt = new HashMap<>();

        for (int i = 0; i < (1 << lo); i++) {
            int t = i;
            long sum = 0;
            for (int j = 0; j < lo; j++) {
                if ((t & 1) == 1) sum += w[j];
                t >>= 1;
            }
            if (sum <= x) cnt.merge(sum, 1L, Long::sum);
        }

        for (int i = 0; i < (1 << hi); i++) {
            int t = i;
            long sum = 0;
            for (int j = 0; j < hi; j++) {
                if ((t & 1) == 1) sum += w[lo + j];
                t >>= 1;
            }
            ans += cnt.getOrDefault(x - sum, 0L);
        }

        out.ans(ans).ln();
    }
}
