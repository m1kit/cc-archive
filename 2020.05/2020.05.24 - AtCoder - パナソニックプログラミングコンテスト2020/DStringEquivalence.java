package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DStringEquivalence {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        dfs(new char[n], 0, n, out);
    }

    private static void dfs(char[] s, int i, int n, LightWriter out) {
        if (i == n) {
            out.ans(String.valueOf(s)).ln();
            return;
        }
        char bound = 'a';
        for (int j = 0; j < i; j++) bound = (char) Math.max(bound, s[j] + 1);
        for (char j = 'a'; j <= bound; j++) {
            s[i] = j;
            dfs(s, i + 1, n, out);
        }
    }
}
