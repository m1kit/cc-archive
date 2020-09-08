package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;
import java.util.BitSet;

public class DFTRobot {

    private static final int OFFSET = 10000;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        char[] s = in.string().toCharArray();
        int x = in.ints(), y = in.ints();
        int[] xs = new int[10000], ys = new int[100000];
        int xlen = 0, ylen = 0;
        int dir = -1;
        for (char c : s) {
            if (c == 'F') {
                if (dir == -1) x--;
                else if (dir % 2 == 0) ys[ylen - 1]++;
                else xs[xlen - 1]++;
            } else {
                dir++;
                if (dir % 2 == 0 && !(ylen > 0 && ys[ylen - 1] == 0)) ylen++;
                else if (!(xlen > 0 && xs[xlen - 1] == 0)) xlen++;
            }
        }
        xs = Arrays.copyOf(xs, xlen);
        ys = Arrays.copyOf(ys, ylen);
        out.ans(solve(x, xs) && solve(y, ys)).ln();
    }

    private static boolean solve(int x, int[] a) {
        int n = a.length;
        boolean[][] dp = new boolean[n + 1][OFFSET * 2];
        dp[0][OFFSET + x] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * OFFSET - a[i]; j++) dp[i + 1][j + a[i]] |= dp[i][j];
            for (int j = a[i]; j < 2 * OFFSET; j++) dp[i + 1][j - a[i]] |= dp[i][j];
        }
        return dp[n][OFFSET];
    }
}
