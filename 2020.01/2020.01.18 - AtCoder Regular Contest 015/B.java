package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] cnt = new int[6];
        for (int i = 0; i < n; i++) {
            double hi = in.doubles(), lo = in.doubles();
            if (35 <= hi) cnt[0]++;
            if (30 <= hi && hi < 35) cnt[1]++;
            if (25 <= hi && hi < 30) cnt[2]++;
            if (25 <= lo) cnt[3]++;
            if (lo < 0 && 0 <= hi) cnt[4]++;
            if (hi < 0) cnt[5]++;
        }
        out.ans(cnt).ln();
    }
}
