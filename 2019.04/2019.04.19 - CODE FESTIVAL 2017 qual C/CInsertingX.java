package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CInsertingX {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string(), r = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int ans = 0;
        int sc = 0, rc = 0;
        while (sc < n && rc < n) {
            if (s.charAt(sc) == r.charAt(rc)) {
                sc++;
                rc++;
            } else if (s.charAt(sc) == 'x') {
                ans++;
                sc++;
            } else if (r.charAt(rc) == 'x') {
                ans++;
                rc++;
            } else {
                out.ansln(-1);
                return;
            }
        }
        ans += 2 * n - sc - rc;
        out.ansln(ans / 2);
    }
}
