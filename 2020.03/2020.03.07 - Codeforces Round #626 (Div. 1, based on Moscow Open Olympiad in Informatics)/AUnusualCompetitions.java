package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AUnusualCompetitions {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        char[] s = in.chars();
        int delta = 0, ans = 0, invStart = -1;
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                delta++;
                if (delta == 0) ans += i - invStart + 1;
            } else {
                delta--;
                if (delta == -1) invStart = i;
            }
        }
        if (delta != 0) {
            out.ans(-1).ln();
            return;
        }
        out.ans(ans).ln();
    }
}
