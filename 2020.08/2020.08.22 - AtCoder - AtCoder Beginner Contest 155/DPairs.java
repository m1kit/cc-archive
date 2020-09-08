package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class DPairs {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long k = in.longs();
        long[] a = in.longs(n);
        IntroSort.sort(a);
        long min = -1_000_000_000_000_000_100L, max = 1_000_000_000_000_000_100L;
        while (max - min > 1) {
            long mid = (min + max) / 2;
            long pos = 0, neg = 0, zero = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    if (0 < mid) zero += n - 1;
                } else if (0 < a[i]) {
                    int lo = 0, hi = n + 1;
                    while (hi - lo > 1) { // a[i] * a[x] < midなる最大のx
                        int piv = (lo + hi) / 2;
                        if (a[i] * a[piv - 1] < mid) lo = piv;
                        else hi = piv;
                    }
                    //System.out.println(a[i] + "LO! " + lo);
                    if (i < lo) pos += lo - 1;
                    else pos += lo;
                } else {
                    int lo = 0, hi = n + 1;
                    while (hi - lo > 1) {
                        int piv = (lo + hi) / 2;
                        if (a[i] * a[n - piv] < mid) lo = piv;
                        else hi = piv;
                    }
                    if (n - i <= lo) pos += lo - 1;
                    else pos += lo;
                }
            }
            long cnt = pos + neg + zero;
            //System.out.println(mid + " => " + neg + "/" + zero + "/" + pos);
            if (k <= cnt / 2) max = mid;
            else min = mid;
        }
        out.ans(min).ln();
    }
}
