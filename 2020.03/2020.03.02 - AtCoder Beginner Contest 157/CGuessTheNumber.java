package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class CGuessTheNumber {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < m; i++) {
            int s = in.ints() - 1;
            int v = in.ints();
            if (n != 1 && s == 0 && v == 0) {
                out.ans(-1).ln();
                return;
            } else if (ans[s] == -1) ans[s] = v;
            else if (ans[s] != v) {
                out.ans(-1).ln();
                return;
            }
        }
        if (n != 1 && ans[0] <= 0) ans[0] = 1;
        for (int i = 0; i < n; i++) {
            out.print((char) (Math.max(ans[i], 0) + '0'));
        }
        out.ln();
    }
}
