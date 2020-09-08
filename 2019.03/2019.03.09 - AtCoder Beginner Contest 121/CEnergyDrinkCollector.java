package jp.llv.atcoder;

import jp.llv.atcoder.lib.geo.Vec2i;
import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class CEnergyDrinkCollector {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        Vec2i[] s = new Vec2i[n];
        for (int i = 0; i < n; i++) {
            s[i] = new Vec2i(in.ints(), in.ints());
        }
        IntroSort.sort(s, Comparator.comparing(v -> v.x));
        long ans = 0;
        for (int i = 0; m > 0; i++) {
            int c = Math.min(m, s[i].y);
            ans += c * (long) s[i].x;
            m -= c;
        }
        out.ansln(ans);
    }
}
