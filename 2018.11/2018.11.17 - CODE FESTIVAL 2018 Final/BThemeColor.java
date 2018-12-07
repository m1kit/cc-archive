package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BThemeColor {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), m = in.ints();
        int[] r = in.ints(m);
        double ans = n * Math.log10(m);

        double[] logfrac = new double[n + 1];
        logfrac[0] = 0;
        for (int i = 1; i <= n; i++) {
            logfrac[i] = logfrac[i - 1] + Math.log10(i);
        }

        int c = n;
        for (int i = 0; i < m; i++) {
            ans -= logfrac[c];
            ans += logfrac[c - r[i]];
            ans += logfrac[r[i]];
            c -= r[i];
        }

        out.println((int) Math.ceil(ans));
    }
}
