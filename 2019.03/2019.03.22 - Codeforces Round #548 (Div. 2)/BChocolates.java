package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class BChocolates {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);

        /*
        ArrayUtil.reverse(a, 0, n);
        long max = Long.MAX_VALUE;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            max = Math.min(max, a[i]);
            ans += max;
            max = Math.max(max - 1, 0);
        }
        out.ansln(ans);*/

        long acc = a[n - 1];
        long can = a[n - 1] - 1;
        for (int i = n - 2; i >= 0; i--) {
            can = Math.min(a[i] - 1, can - 1);
            if (can < -1) can = -1;
            acc += can + 1;
        }
        out.ansln(acc);
    }
}
