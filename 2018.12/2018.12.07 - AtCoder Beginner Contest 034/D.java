package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.structure.Pair;
import jp.llv.atcoder.lib.structure.Vec2l;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class D {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), k = in.ints();
        List<E> e = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            e.add(new E(in.longs(), in.doubles()));
        }
        E ans = new E(0L, 0d);
        for (int i = 0; i < k; i++) {
            final E y = ans;
            e.sort(Comparator.comparing(x -> -((x.key * x.value + y.key * y.value) / (x.key + y.key))));
            E t = e.remove(0);
            ans = new E(ans.key + t.key, (t.key * t.value + ans.key * ans.value) / (t.key + ans.key));
        }
        out.println(ans.value);
    }

    private static class E extends Pair<Long, Double> {
        public E(Long key, Double value) {
            super(key, value);
        }
    }

}
