package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class EArchaeology {

    private static final int INF = 2_000_000;
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        String s = in.string();
        int n = s.length();

        int l = 0, r = n - 1;
        StringBuilder sb = new StringBuilder();
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                sb.append(s.charAt(l));
                l++;
                r--;
            } else if (s.charAt(l) == s.charAt(r - 1)) {
                r--;
            } else if (s.charAt(l + 1) == s.charAt(r)) {
                l++;
            } else {
                r--;
                l++;
            }
        }

        String ans = sb.toString();
        if (l == r) ans += s.charAt(l);
        ans += sb.reverse().toString();
        if (ans.length() < n / 2) {
            out.ans(IMPOSSIBLE).ln();
        } else {
            out.ans(ans).ln();
        }
    }
}
