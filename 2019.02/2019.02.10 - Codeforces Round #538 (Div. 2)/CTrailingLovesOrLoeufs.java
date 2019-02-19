package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.IntMath;

import java.util.Map;

public class CTrailingLovesOrLoeufs {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        long n = in.longs(), b = in.longs();
        long ans = Long.MAX_VALUE;
        Map<Long, Integer> pf = IntMath.primeFactorize(b);
        for (Map.Entry<Long, Integer> ent : pf.entrySet()) {
            long fc = count(ent.getKey(), n);
            //System.out.println(ent.getKey()+"->"+fc);
            ans = Math.min(ans,  fc / ent.getValue());
        }
        out.ans(ans).ln();
    }

    private static long count(long p, long n) {
        if (p > n) {
            return 0;
        }
        long q = p;
        long ans = 0;
        while (true) {
            ans += n / q;
            if (n / q < p || (q = q * p) > n || q < 0) {
                return ans;
            }
        }
    }
}
