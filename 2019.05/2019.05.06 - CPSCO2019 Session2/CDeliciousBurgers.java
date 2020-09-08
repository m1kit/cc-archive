package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class CDeliciousBurgers {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        String s = in.string();
        int[] a = new int[n - 1];
        int depth = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
            }
            a[i] = depth;
        }
        IntroSort.sort(a);
        ArrayUtil.reverse(a, 0, n - 1);
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += a[i];
        }
        out.ans(ans).ln();
    }
}
