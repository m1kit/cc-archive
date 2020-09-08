package jp.llv.atcoder;

import jp.llv.atcoder.lib.geo.Vec2l;
import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.IntMath;

import java.util.HashMap;
import java.util.Map;

public class DZeroQuantityMaximization {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        long[] a = in.longs(n), b = in.longs(n);
        Map<Vec2l, Integer> map = new HashMap<>();
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                if (b[i] == 0) {
                    t++;
                }
                continue;
            } else if (b[i] == 0) {
                map.merge(new Vec2l(0, 0), 1, (x, y) -> x + y);
                continue;
            }
            if (b[i] < 0) {
                a[i] *= -1;
                b[i] *= -1;
            }

            long gcd = IntMath.gcd(Math.abs(a[i]), Math.abs(b[i]));
            Vec2l p = new Vec2l(b[i] / gcd, a[i] / gcd);
            map.merge(p, 1, (x, y) -> x + y);
        }
        out.ansln(t + map.values().stream().mapToInt(x -> x).max().orElse(0));
    }
}
