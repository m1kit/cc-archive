package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.mod.ModMath;
import jp.llv.atcoder.lib.structure.Vec2i;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class D {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final Map<Vec2i, Long> dp = new HashMap<>();

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        long n = in.longs(), k = in.longs();
        long ans = 1;
        for (int i = 0; i < k; i++) {
            ans *= (n + i);
            ans %= MOD;
        }
        ModMath m = new ModMath();
        for (int i = 2; i<= k; i++) {
            ans *= m.inv(i);
            ans %= MOD;
        }
        out.println(ans);
    }
}
