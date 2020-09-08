package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.IntMath;
import jp.llv.atcoder.lib.util.ArrayUtil;

public class DLazyFaith {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int a = in.ints(), b = in.ints(), q = in.ints();
        long[] s = new long[a + 2], t = new long[b + 2];
        s[0] = t[0] = -10_000_000_000L;
        for (int i = 0; i < a; i++) {
            s[i + 1] = in.longs();
        }
        for (int i = 0; i < b; i++) {
            t[i + 1] = in.longs();
        }
        s[a + 1] = t[b + 1] = 20_000_000_000L;
        for (int i = 0; i < q; i++) {
            long x = in.longs();
            long sl = x - s[Math.max(0, ArrayUtil.lowerBound(s, x + 1) - 1)];
            long tl = x - t[Math.max(0, ArrayUtil.lowerBound(t, x + 1) - 1)];
            long sr = s[ArrayUtil.lowerBound(s, x)] - x;
            long tr = t[ArrayUtil.lowerBound(t, x)] - x;
            out.ansln(IntMath.min(
                    Math.max(sl, tl),
                    Math.max(sr, tr),
                    2 * sl + tr,
                    2 * tl + sr,
                    sl + 2 * tr,
                    tl + 2 * sr
            ));
        }
    }
}
