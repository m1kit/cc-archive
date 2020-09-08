package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class BVerseForSanta {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints(), k = in.ints();
            long[] a = in.longs(n);
            long[] s = IntMath.sum(a);
            int max = 0, maxIndex = 0;

            for (int i = 1; i <= n; i++) {
                if (s[i] <= k) max = i;
                else break;
            }
            for (int i = 0; i < n; i++) {
                int ok = 0, ng = n + 1;
                while (ng - ok > 1) {
                    int mid = (ok + ng) / 2;
                    long sum = s[mid];
                    if (i < mid) sum -= a[i];
                    if (sum > k) ng = mid;
                    else ok = mid;
                }
                if (ok > max) {
                    max = ok;
                    maxIndex = i + 1;
                }
            }
            out.ans(maxIndex).ln();
        }
    }
}
