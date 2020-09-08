package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BRedOrBlue {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        String s  = in.string();
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                c++;
            }
        }
        if (n - c < c) {
            out.ansln(YES);
        } else {
            out.ansln(NO);
        }
    }
}
