package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class CSashaAndABitOfRelax {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        int[] t = new int[n + 1];
        for (int i = 0; i < n; i++) {
            t[i + 1] = t[i] ^ a[i];
        }


        long ans = 0;

        int[] c = new int[0b1_00000_00000_00000_00000];
        for (int i = 0; i <= n; i += 2) {
            c[t[i]]++;
        }
        for (int i = 0; i < 0b1_00000_00000_00000_00000; i++) {
            ans += (c[i] * (c[i] - 1L)) / 2L;
        }

        Arrays.fill(c, 0);
        for (int i = 1; i <= n; i += 2) {
            c[t[i]]++;
        }
        for (int i = 0; i < 0b1_00000_00000_00000_00000; i++) {
            ans += (c[i] * (c[i] - 1L)) / 2L;
        }
        out.ansln(ans);
    }
}
