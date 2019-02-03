package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class BSubstringRemoval {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        String s = in.string();
        char l = s.charAt(0), r = s.charAt(n - 1);
        long li = 0, ri = 0;
        for (int i = 1; i < n; i++) {
            if (l != s.charAt(i)) {
                li = i - 1;
                break;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (r != s.charAt(i)) {
                ri = i + 1;
                break;
            }
        }
        if (l == r) {
            out.println((li + 2L) * (n - ri + 1L) % MOD);
        } else {
            out.println((li + (n - ri) + 2L) % MOD);
        }
    }
}
