package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.counting.Permutation;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.stream.IntStream;

public class CNumberingBlocks {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int[] s = in.ints(3);
        int n = s[0] + s[1] + s[2];
        int[] p = IntStream.range(0, n).toArray();
        int ans = 0;
        while (p != null) {
            int[][] mat = new int[3][3];
            ArrayUtil.fill(mat, 100);
            int cur = 0;
            for (int r = 0; r < 3; r++) for (int i = 0; i < s[r]; i++) mat[r][i] = p[cur++];
            boolean ok = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    if (mat[i][j] > mat[i][j + 1]) ok = false;
                    if (mat[j][i] > mat[j + 1][i]) ok = false;
                }
            }
            if (ok) ans++;
            p = Permutation.nextPermutation(p);
        }
        out.ans(ans).ln();
    }
}
