package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class GABMatrix {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints(), m = in.ints(), a = in.ints(), b = in.ints();
            char[][] ans = new char[n][m];
            ArrayUtil.fill(ans, '0');
            int col = 0;
            int[] sum = new int[m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < a; j++) {
                    sum[col]++;
                    ans[i][col] = '1';
                    if (++col == m) col = 0;
                }
            }
            boolean ok = true;
            for (int i = 0; i < m; i++) {
                if (sum[i] != b) {
                    ok = false;
                    break;
                }
            }
            out.ans(ok).ln();
            if (ok) {
                for (int i = 0; i < n; i++) out.ans(String.valueOf(ans[i])).ln();
            }
        }
    }
}
