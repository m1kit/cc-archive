package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CMakeGood {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            long[] a = in.longs(n);
            long sum = 0, xor = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i];
                xor ^= a[i];
            }
            out.ans(2).ln();
            out.ans(xor).ans(sum + xor).ln();
            //System.out.println("XOR="+(sum + xor) * 2 + " SUM="+(sum + xor + sum + xor));
        }
    }
}
