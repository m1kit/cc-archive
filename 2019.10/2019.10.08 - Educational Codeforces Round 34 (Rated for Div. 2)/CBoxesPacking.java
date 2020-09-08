package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashMap;
import java.util.Map;

public class CBoxesPacking {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cnt.merge(in.ints(), 1, Integer::sum);
        }
        int ans = 0;
        for (int value : cnt.values()) ans = Math.max(ans, value);
        out.ans(ans).ln();
    }
}
