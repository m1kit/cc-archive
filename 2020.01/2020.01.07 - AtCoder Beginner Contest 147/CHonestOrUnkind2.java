package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.BitMath;

import java.util.Arrays;

public class CHonestOrUnkind2 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), mask = (1 << n) - 1, ans = 0;
        int[][] table = new int[2][n];
        for (int i = 0; i < n; i++) {
            int l = in.ints();
            for (int j = 0; j < l; j++) {
                int x = in.ints() - 1, y = in.ints();
                table[y][i] |= 1 << x;
            }
        }
        for (int i = 0; i < (1 << n); i++) {
            int t = i, honest = 0, unkind = 0;
            for (int j = 0; j < n; j++) {
                if ((t & 1) == 1) {
                    honest |= table[1][j];
                    unkind |= table[0][j];
                }
                t >>= 1;
            }
            if ((honest & ~i) != 0 || (unkind & i) != 0 || (honest & unkind) != 0) continue;
            ans = Math.max(ans, BitMath.count(i));
        }
        out.ans(ans).ln();
    }
}
