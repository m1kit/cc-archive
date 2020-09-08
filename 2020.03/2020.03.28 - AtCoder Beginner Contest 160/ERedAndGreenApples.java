package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class ERedAndGreenApples {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int x = in.ints(), y = in.ints(), a = in.ints(), b = in.ints(), c = in.ints();
        int[] p = in.ints(a), q = in.ints(b), r = in.ints(c);
        long[] ps = makeSum(a, p), qs = makeSum(b, q), rs = makeSum(c, r);

        long ans = 0;
        for (int i = Math.max(0, x - c); i <= x; i++) {
            int min = Math.max(0, x - i + y - c), max = y + 1;
            while (max - min > 10) {
                int p1 = min + (max - min) / 3, p2 = min + (max - min) * 2 / 3;
                if (ps[i] + qs[p1] + rs[x - i + y - p1] < ps[i] + qs[p2] + rs[x - i + y - p2]) min = p1;
                else max = p2;
            }
            for (int j = min; j < max; j++) {
                ans = Math.max(ans, ps[i] + qs[j] + rs[x - i + y - j]);
            }
        }
        out.ans(ans).ln();
    }

    private static long[] makeSum(int n, int[] a) {
        IntroSort.sort(a);
        ArrayUtil.reverse(a, 0, n);
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) s[i + 1] = s[i] + a[i];
        return s;
    }
}
