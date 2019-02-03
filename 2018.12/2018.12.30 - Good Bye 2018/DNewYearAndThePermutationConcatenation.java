package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.counting.Permutation;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class DNewYearAndThePermutationConcatenation {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = 998244353;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long nn = n;
        long[] a = new long[n + 1];
        a[0] = 0;
        a[1] = 0;
        for (int i = 2; i <= n; i++) {
            a[i] = i * (a[i - 1] + 1);
            a[i] %= MOD;
        }
        for (int i = 2; i <= n; i++) {
            nn *= i;
            nn %= MOD;
        }
        out.println((nn - a[n] + MOD) % MOD);
    }
}
