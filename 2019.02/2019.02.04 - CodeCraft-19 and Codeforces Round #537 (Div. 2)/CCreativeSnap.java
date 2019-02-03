package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.BitMath;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;

public class CCreativeSnap {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    private static int n, k;
    private static long a, b;
    private static int[] p;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        n = in.ints();
        k = in.ints();
        a = in.longs();
        b = in.longs();
        p = in.ints(k);
        Arrays.sort(p);
        for (int i = 0; i < k; i++) {
            p[i]--;
        }
        out.ans(solve(0, 1 << n)).ln();
    }

    public static long solve(int l, int r) {
        int w = r - l;
        if (w == 1) {
            return b * (ArrayUtil.lowerBound(p, r) - ArrayUtil.lowerBound(p, l));
        }
        int m = (l + r) / 2;
        int cl = ArrayUtil.lowerBound(p, m) - ArrayUtil.lowerBound(p, l);
        int cr = ArrayUtil.lowerBound(p, r) - ArrayUtil.lowerBound(p, m);
        if (cl == 0 && cr == 0) {
            return a;
        } else if (cl == 0) {
            return Math.min(b * w * cr, a + solve(m, r));
        } else if (cr == 0) {
            return Math.min(b * w * cl, a + solve(l, m));
        } else {
            return Math.min(b * w * (cl + cr), solve(l, m) + solve(m, r));
        }
    }
}
