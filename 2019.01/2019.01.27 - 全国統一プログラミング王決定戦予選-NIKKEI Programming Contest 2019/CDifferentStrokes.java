package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.geo.Vec2i;
import jp.llv.atcoder.lib.geo.Vec3i;
import jp.llv.atcoder.lib.geo.Vec3l;

import java.util.Arrays;
import java.util.Comparator;

public class CDifferentStrokes {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        Vec3l[] tkhs = new Vec3l[n];
        for (int i = 0; i < n; i++) {
            tkhs[i] = new Vec3l(in.ints(), in.ints(), 0);
        }
        Vec3l[] aoki = tkhs.clone();
        Comparator<Vec3l> cmp0 = Comparator.comparing(dish -> - dish.x - dish.y);
        Comparator<Vec3l> cmp1 = Comparator.comparing(dish -> - dish.x - dish.y);
        Arrays.sort(tkhs, cmp0.thenComparing(dish -> -dish.x));
        Arrays.sort(aoki, cmp1.thenComparing(dish -> -dish.y));
        int c0 = 0, c1 = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                while (tkhs[c0].z == 1) {
                    c0++;
                }
                tkhs[c0].z = 1;
                ans += tkhs[c0].x;
            } else {
                while (tkhs[c1].z == 1) {
                    c1++;
                }
                tkhs[c1].z = 1;
                ans -= tkhs[c1].y;
            }
        }
        out.ans(ans).ln();
    }
}
