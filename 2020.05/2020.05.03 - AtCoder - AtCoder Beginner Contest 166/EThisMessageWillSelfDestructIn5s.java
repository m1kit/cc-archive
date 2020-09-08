package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashMap;
import java.util.Map;

public class EThisMessageWillSelfDestructIn5s {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        Map<Long, Integer> map = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += map.getOrDefault(i + 1 - a[i], 0);
            map.merge(a[i] + i + 1, 1, Integer::sum);
        }
        out.ans(ans).ln();
    }
}
