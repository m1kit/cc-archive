package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class DXORWorld {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long a = in.longs(), b = in.longs();
        //System.out.println(calc(3));
        if (a == 0) {
            out.ans(calc(b));
        } else {
            out.ans(calc(b) ^ calc(a - 1));
        }
    }

    private static long calc(long x) {
        long res = 0;
        for (int i = 0; i < 60; i++) {
            long hcycl = 1L << i;
            long cycl = 1L << (i + 1);
            long c = (x + 1) / cycl * hcycl;
            long v = Math.max(0, (x + 1) % cycl - hcycl);
            if ((c + v) % 2 == 1) {
                res |= 1L << i;
            }
        }
        return res;
    }
}
