package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), q = in.ints();
        int[] s = new int[n + 1];
        for (int i = 0; i < q; i++) {
            s[in.ints() - 1]++;
            s[in.ints()]--;
        }
        for (int i = 1; i <= n; i++) s[i] += s[i - 1];
        for (int i = 0; i < n; i++) out.print((char) (s[i] % 2 + '0'));
        out.ln();
    }
}
