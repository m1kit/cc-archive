package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class EPolygon {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints();
            char[][] s = in.chars(n);
            boolean ok = true;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (s[i][j] == '1' && s[i + 1][j] == '0' && s[i][j + 1] == '0') {
                        ok = false;
                        break;
                    }
                }
            }
            out.ans(ok).ln();
        }
    }
}
