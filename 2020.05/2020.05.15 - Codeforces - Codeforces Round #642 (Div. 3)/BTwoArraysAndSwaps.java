package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class BTwoArraysAndSwaps {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints(), k = in.ints(), ans = 0;
            int[] a = in.ints(n), b = in.ints(n);
            IntroSort.sort(a);
            IntroSort.sort(b);
            ArrayUtil.reverse(b, 0, n);
            for (int i = 0; i < n; i++)  ans += i < k && a[i] < b[i] ? b[i] : a[i];
            out.ans(ans).ln();
        }
    }
}
