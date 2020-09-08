package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ECoinAuthentication {

    private static final int MOD = (int) 1e9 + 7;
    private static final int[] VALUES = {8, 9, 10, 11, 12};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] ans = new int[n];
        for (int i = 0; i < 10; i++) {
            if (i * 5 >= n) continue;

            out.ans("?");
            int mul = 1;
            for (int j = 0; j < i * 5; j++) {
                out.ans(0);
            }
            for (int j = 0; j < 5; j++) {
                if (i * 5 + j >= n) continue;
                out.ans(mul);
                mul *= 10;
            }
            for (int j = (i + 1) * 5; j < n; j++) {
                out.ans(0);
            }
            out.ln().flush();
            int res = in.ints();

            int k = 1;
            for (int j = 0; j < 5; j++) {
                if (i * 5 + j >= n) continue;
                k *= 5;
            }
            for (int j = 0; j < k; j++) {
                int cp = j;
                int v = 0;
                mul = 1;
                for (int l = 0; l < 5; l++) {
                    if (i * 5 + l >= n) continue;
                    v += VALUES[cp % 5] * mul;
                    cp /= 5;
                    mul *= 10;
                }
                cp = j;
                if (v == res) {
                    for (int l = 0; l < 5; l++) {
                        if (i * 5 + l >= n) continue;
                        ans[i * 5 + l] = VALUES[cp % 5];
                        cp /= 5;
                    }
                }
            }
        }
        out.ans("!");
        for (int i = 0; i < n; i++) {
            out.ans(ans[i] % 2);
        }
        out.ln().flush();
    }
}
