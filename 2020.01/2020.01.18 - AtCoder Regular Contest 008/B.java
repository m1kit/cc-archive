package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(), ans = 0;
        int[] a = new int[26], b = new int[26];
        char[] s = in.next().toCharArray(), t = in.next().toCharArray();
        for (int i = 0; i < n; i++) a[s[i] - 'A']++;
        for (int i = 0; i < m; i++) b[t[i] - 'A']++;
        for (int i = 0; i < 26; i++) {
            if (a[i] > 0 && b[i] == 0) {
                out.ans(-1).ln();
                return;
            } else if (b[i] == 0) continue;
            ans = Math.max(ans, (a[i] + b[i] - 1) / b[i]);
        }
        out.ans(ans).ln();
    }
}
