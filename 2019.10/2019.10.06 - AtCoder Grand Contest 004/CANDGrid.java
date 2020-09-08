package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class CANDGrid {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        char[][] ans0 = new char[n][m], ans1 = new char[n][m];
        ArrayUtil.fill(ans0, '.');
        ArrayUtil.fill(ans1, '.');
        for (int i = 0; i < m; i++) {
            ans0[0][i] = ans1[n - 1][i] = '#';
            for (int j = 1; j < n - 1; j++) {
                if (i % 2 == 0) ans0[j][i] = '#';
                else ans1[j][i] = '#';
            }
        }
        for (int i = 0; i < n; i++) {
            char[] s = in.string().toCharArray();
            for (int j = 0; j < m; j++) {
                if (s[j] == '#') ans0[i][j] = ans1[i][j] = '#';
            }
        }
        for (int i = 0; i < n; i++) out.ans(String.valueOf(ans0[i])).ln();
        out.ln();
        for (int i = 0; i < n; i++) out.ans(String.valueOf(ans1[i])).ln();
    }
}
