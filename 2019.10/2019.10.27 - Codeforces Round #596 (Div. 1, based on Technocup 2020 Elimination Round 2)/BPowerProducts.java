package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BPowerProducts {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        long[] a = in.longs(n), b = new long[n];
        for (int i = 0; i < n; i++) {
            Map<Long, Integer> pf = IntMath.primeFactorize(a[i]);
            long v = b[i] = 1;
            for (Map.Entry<Long, Integer> f : pf.entrySet()) {
                int count = f.getValue() % k;
                if (count == 0) continue;
                for (int j = 0; j < count; j++) v *= f.getKey();
                for (int j = count; j < k; j++) b[i] *= f.getKey();
            }
            a[i] = v;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        long ans = 0;
        Map<Long, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ans += cnt.getOrDefault(b[i], 0);
            cnt.merge(a[i], 1, Integer::sum);
        }
        out.ans(ans).ln();
    }
}
