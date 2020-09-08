package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class E1NumericalSequenceEasyVersion {

    private static final int MAX = 1_000_000;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int q = in.ints();
        long[] blocklen = new long[MAX];
        for (int i = 1; i < MAX; i++) {
            blocklen[i] = blocklen[i - 1] + length(i);
        }
        long[] sum = new long[MAX];
        for (int i = 1; i < MAX; i++) {
            sum[i] = sum[i - 1] + blocklen[i];
        }

        for (int query = 0; query < q; query++) {
            long k = in.longs() - 1;
            for (int i = 1; k >= blocklen[i]; i++) k -= blocklen[i];
            for (int i = 1;; i++) {
                int len = length(i);
                if (k >= len) k -= len;
                else {
                    out.ans(Integer.toString(i).charAt((int) k)).ln();
                    break;
                }
            }
        }
    }

    private static int length(int x) {
        return x < 10 ? 1 : 1 + length(x / 10);
    }
}
