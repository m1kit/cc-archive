package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.IntMath;

import java.util.HashMap;
import java.util.Map;

public class CDivisorGame {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        long n = in.longs();
        Map<Long, Integer> pf = new HashMap<>();
        for (long i = 2; i * i <= n; i++) {
            int c = 0;
            while (n % i == 0) {
                n /= i;
                c++;
            }
            if (c > 0) {
                pf.put(i, c);
            }
        }
        if (n > 1) {
            pf.put(n, 1);
        }

        long ans = 1;
        for (Map.Entry<Long, Integer> ent : pf.entrySet()) {
            ans *= (ent.getValue() + 1L);
        }
        out.ans(pf.size()).ans(ans - 1).ln();
    }
}
