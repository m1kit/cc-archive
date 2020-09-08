package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashSet;

public class HBinaryMedian {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints(), m = in.ints();
            long mid = (1L << (m - 1)) - 1, ans = mid;
            HashSet<Long> num = new HashSet<>();
            for (int i = 0; i < n; i++) {
                long x = Long.parseLong(in.string(), 2);
                num.add(x);
                if (i % 2 == 0) {
                    if (x <= ans) ans++;
                    while (num.contains(ans)) ans++;
                } else {
                    if (x >= ans) ans--;
                    while (num.contains(ans)) ans--;
                }
            }
            char[] str = new char[m];
            for (int i = 0; i < m; i++) {
                str[m - i - 1] = (char) ('0' + ans % 2);
                ans /= 2;
            }
            out.ans(String.valueOf(str)).ln();
        }
    }
}
