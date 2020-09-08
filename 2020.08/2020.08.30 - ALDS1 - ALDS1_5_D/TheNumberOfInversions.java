package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.seqence.InvNum;

public class TheNumberOfInversions {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int n = in.ints();
        long[] a = in.longs(n);
        out.ans(InvNum.calc(a)).ln();
    }
}
