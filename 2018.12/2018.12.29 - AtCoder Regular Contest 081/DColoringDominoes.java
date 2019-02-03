package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class DColoringDominoes {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        String s1 = in.string(), s2 = in.string();
        int m = 0;
        boolean[] v = new boolean[n];
        int i = 0;
        while (i < n) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                v[m] = true;
                i += 2;
            }
            m++;
        }
        long ans = v[0] ? 6 : 3;
        for (i = 1; i < m; i++) {
            if (v[i]) {
                if (v[i - 1]) {//横横
                    ans *= 3;
                    ans %= MOD;
                } else {//縦横
                    ans *= 2;
                    ans %= MOD;
                }
            } else {
                if (v[i - 1]) {//横縦
                    //pass
                } else {//縦縦
                    ans *= 2;
                    ans %= MOD;
                }
            }
        }
        out.println(ans);
    }
}
