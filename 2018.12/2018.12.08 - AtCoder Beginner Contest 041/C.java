package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.structure.Vec2i;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class C {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        Vec2i[] a = new Vec2i[n];
        for (int i = 1; i <= n; i++) {
            a[i - 1] = new Vec2i(i, in.ints());
        }
        Arrays.sort(a, Comparator.comparing(x -> -x.y));
        for (Vec2i e : a) {
            out.println(e.x);
        }
    }
}
