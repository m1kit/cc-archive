package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.StringUtil;

import java.util.Arrays;

public class EWhoSaysAPun {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        String s = in.string();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] z = StringUtil.zalgorithm(s.substring(i));
            for (int j = 0; j < n - i; j++) {
                ans = Math.max(ans, Math.min(j, z[j]));
            }
        }
        out.ans(ans).ln();
    }
}
