package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BDraw {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long ans = 1;
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            int x = in.ints(), y = in.ints();
            if (x == a && y == b) continue;
            if (a < b && b <= x) {
                a = b;
                ans++;
            } else if (a < b) {
                a = x;
                b = y;
                continue;
            }
            if (b < a && a <= y) {
                b = a;
                ans++;
            } else if (b < a) {
                b = y;
                a = x;
                continue;
            }
            ans += Math.min(x, y) - Math.max(a, b);
            a = x;
            b = y;
        }
        out.ans(ans).ln();
    }
}
