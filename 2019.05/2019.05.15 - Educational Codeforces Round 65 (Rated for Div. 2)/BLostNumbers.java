package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.counting.Permutation;

public class BLostNumbers {

    private static final int MOD = (int) 1e9 + 7;
    private static final int[] NUMBERS = {4, 8, 16, 15, 23, 42};
    private static final int[] UNIQUE =  {0, 0, 0,   5, 23,  7};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int[] a = new int[4];
        for (int i = 0; i < 4; i++) {
            out.ans("?").ans(i + 1).ans(i + 2).ln().flush();
            a[i] = in.ints();
        }
        int[] ans = {4, 8, 15, 16, 23, 42};
        outer: while (ans != null) {
            for (int i = 0; i < 4; i++) {
                if (ans[i] * ans[i + 1] != a[i]) {
                    ans = Permutation.nextPermutation(ans);
                    continue outer;
                }
            }
            out.ans("!").ans(ans).ln().flush();
            break;
        }
    }
}
