package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.Arrays;

public class DWeLoveABC {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        String s = in.string();
        int n = s.length();

        long[] pow = new long[n + 1];
        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] * 3) % MOD;
        }

        int[] a = new int[n + 2];
        int[] c = new int[n + 2];
        int[] q = new int[n + 2];
        for (int i = 0; i < n; i++) {
            a[i + 1] = a[i] + (s.charAt(i) == 'A' ? 1 : 0);
            c[i + 1] = c[i] + (s.charAt(i) == 'C' ? 1 : 0);
            q[i + 1] = q[i] + (s.charAt(i) == '?' ? 1 : 0);
        }
        a[n + 1] = a[n];
        c[n + 1] = c[n];
        q[n + 1] = q[n];

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int d = q[n + 1];
            if (s.charAt(i) == 'A' || s.charAt(i) == 'C') {
                continue;
            } else if (s.charAt(i) == '?') {
                d--;
            }
            ans += pow[d] * a[i] * (c[n + 1] - c[i + 1]);
            ans %= MOD;
            ans += pow[Math.max(d - 1, 0)] * a[i] * (q[n + 1] - q[i + 1]);
            ans %= MOD;
            ans += pow[Math.max(d - 1, 0)] * q[i] * (c[n + 1] - c[i + 1]);
            ans %= MOD;
            ans += pow[Math.max(d - 2, 0)] * q[i] * (q[n + 1] - q[i + 1]);
            ans %= MOD;
        }
        out.println(ans);
    }
}
