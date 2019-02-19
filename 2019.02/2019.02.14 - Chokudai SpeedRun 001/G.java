package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

public class G {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        long[] a = in.longs(n);
        long ans = 0;
        long off = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans += off * (a[i] % MOD) % MOD;
            ans %= MOD;
            while (a[i] > 0) {
                a[i] /= 10;
                off *= 10;
                off %= MOD;
            }
        }
        out.ansln(ans);
    }
}
