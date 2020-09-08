package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashMap;
import java.util.Map;

public class CDominatedSubarray {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            int[] a = in.ints(n);
            int ans = Integer.MAX_VALUE;
            Map<Integer, Integer> index = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (index.containsKey(a[i])) ans = Math.min(ans, i - index.get(a[i]) + 1);
                index.put(a[i], i);
            }
            out.ans(ans == Integer.MAX_VALUE ? -1 : ans).ln();
        }
    }
}
