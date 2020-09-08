package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.structure.IntMultiSet;

import java.util.stream.IntStream;

public class BStonedGame {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints();
            int[] a = in.ints(n);
            int max = IntMath.max(a), sum = IntStream.of(a).sum();
            if (sum < max * 2) {
                out.ans("T").ln();
            } else if (sum % 2 == 0) {
                out.ans("HL").ln();
            } else {
                out.ans("T").ln();
            }
        }
    }
}
