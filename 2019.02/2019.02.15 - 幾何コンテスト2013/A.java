package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.geo.Vec3i;
import jp.llv.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class A {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        Vec3i[] vs = new Vec3i[300];
        for (int i = 0; i < 300; i++) {
            vs[i] = new Vec3i(in.ints(), in.ints(), i + 1);
        }
        IntroSort.sort(vs, Comparator.comparing(v -> (v.x + 1000) * 1000 + v.y));
        out.ansln(100);
        for (int i = 0; i < 300; i+=3) {
            out.ans(vs[i].z).ans(vs[i + 1].z).ans(vs[i + 2].z).ln();
        }
    }
}
