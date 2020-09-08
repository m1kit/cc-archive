package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class CEhabAndASpecialColoringProblem {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] ans = new int[n + 1];
        int val = 0;
        for (int i = 2; i <= n; i++) {
            if (ans[i] != 0) continue;
            int j = i;
            val++;
            while (j <= n) {
                if (ans[j] == 0) {
                    ans[j] = val;
                }
                j += i;
            }
        }
        for (int i = 2; i <= n; i++) {
            out.ans(ans[i]);
        }
        out.ln();
    }
}
