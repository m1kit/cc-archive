package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class CPerfectTriples {

    private static final int[][] TABLE = {
            {0, 1, 2, 3},
            {0, 2, 3, 1},
            {0, 3, 1, 2},
    };
    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            long n = in.longs(), block = (n - 1) / 3;
            int ord = (int) ((n + 2) % 3);

            int level = 0;
            while (((1L << (2 * (level + 1))) - 1) / 3 <= block) level++;
            long p = block - ((1L << (2 * level)) - 1) / 3;
            long ans = (1L << (2 * level)) * (ord + 1);
            for (int i = 0; i < level; i++) {
                ans += (1L << (2 * i)) * TABLE[ord][(int) ((p >> (i * 2)) & 3)];
            }
            out.ans(ans).ln();
        }
    }
}
