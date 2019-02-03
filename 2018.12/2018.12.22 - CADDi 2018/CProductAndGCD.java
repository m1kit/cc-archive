package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.IntMath;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CProductAndGCD {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        Map<Long, Integer> factor = new HashMap<>();
        long n = in.longs(), p = in.longs();
        Long f = null;
        while ((f = IntMath.getPrimeFactor(p)) != null) {
            factor.merge(f, 1, (x, y) -> x + y);
            p /= f;
        }
        if (p > 1) {
            factor.merge(p, 1, (x, y) -> x + y);
        }

        long ans = 1;
        for (Map.Entry<Long, Integer> e : factor.entrySet()) {
            for (int i = 0; i < e.getValue() / n; i++) {
                ans *= e.getKey();
            }
        }
        out.println(ans);
    }
}
