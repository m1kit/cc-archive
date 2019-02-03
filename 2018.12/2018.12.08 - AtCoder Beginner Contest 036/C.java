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
        Vec2i[] raw = new Vec2i[n];
        int[] compressed = new int[n];
        for (int i = 0; i < n; i++) {
            raw[i] = new Vec2i(i, in.ints());
        }
        Arrays.sort(raw, Comparator.comparing(x -> x.y));
        int m = -1;
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (last != raw[i].y) {
                m++;
            }
            compressed[raw[i].x] = m;
            last = raw[i].y;
        }
        Arrays.stream(compressed).forEach(out::println);
    }
}
