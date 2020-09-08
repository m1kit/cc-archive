package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashSet;
import java.util.List;

public class D {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            outer: for (int j = 1; j <= m; j++) {
                int x = i, y = j;
                for (int k = 0; k < 1000; k++) {
                    if (x == 0 || y == 0) continue outer;
                    if (x < y) {
                        x = rev(x);
                    } else {
                        y = rev(y);
                    }
                    if (x < y) {
                        y -= x;
                    } else {
                        x -= y;
                    }
                }
                ans++;
            }
        }
        out.ans(ans).ln();
    }

    private static int rev(int val) {
        int res = 0;
        while (val > 0) {
            res *= 10;
            res += val % 10;
            val /= 10;
        }
        return res;
    }
}
