package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class DGrid00100 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints(), k = in.ints();
            char[][] ans = new char[n][n];
            ArrayUtil.fill(ans, '0');
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n && 0 < k; j++, k--) {
                    ans[j][(i+j)%n]='1';
                }
            }
            int[] r = new int[n], c = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ans[i][j] == '0') continue;
                    r[i]++;
                    c[j]++;
                }
            }
            long rd = IntMath.max(r) - IntMath.min(r), cd = IntMath.max(c) - IntMath.min(c);
            out.ans(rd * rd + cd * cd).ln();
            for (int i = 0; i < n; i++) out.ans(String.valueOf(ans[i])).ln();
        }
    }
}
