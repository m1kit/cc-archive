package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.IntMath;

import java.io.PrintWriter;
import java.util.Arrays;

public class DEqualCut {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        long p = a[0], q = a[1], r = a[2], s = Arrays.stream(a).skip(3).mapToLong(i -> i).sum();
        int ab = 1, bc = 2, cd = 3;
        long ans = Long.MAX_VALUE;
        do {
            while (bc - ab > 1 && Math.abs(p - q) >= Math.abs(p - q + 2 * a[ab])) {
                p += a[ab];
                q -= a[ab];
                ab++;
            }
            while (n - cd > 1 && Math.abs(r - s) >= Math.abs(r - s + 2 * a[cd])) {
                r += a[cd];
                s -= a[cd];
                cd++;
            }
            ans = Math.min(ans, IntMath.max(p, q, r, s) - IntMath.min(p, q, r, s));

            q += a[bc];
            r -= a[bc];
            bc++;
        } while (bc < n - 1);
        out.println(ans);
    }
}
