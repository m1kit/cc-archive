package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class BBalloons {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        long[] a = in.longs(n);
        IntroSort.sort(a);
        ArrayUtil.reverse(a, 0, n);
        int ans = 0;
        while (m > 0) {
            m -= a[ans];
            ans++;
        }
        out.ans(ans).ln();
    }
}
