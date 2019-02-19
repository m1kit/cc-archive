package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.geo.Vec2i;
import jp.llv.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class CBBuBBBlesort {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        Vec2i[] a = new Vec2i[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Vec2i(in.ints(), i);
        }
        IntroSort.sort(a, Comparator.comparing(e -> e.x));
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 != a[i].y % 2) {
                c++;
            }
        }
        out.ans(c / 2).ln();
    }
}
