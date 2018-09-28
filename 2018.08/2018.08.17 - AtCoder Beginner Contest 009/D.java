package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class D {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        /* 1. PREPARATION */
        int k = in.nextInt(), m = in.nextInt() - 1;
        long[] v = new long[k];
        long[][][] pows = new long[32][][];
        long[][] initial = new long[k][k];
        long[][] unit = new long[k][k];
        pows[0] = initial;
        IntStream.range(0, k).forEach(i -> v[i] = in.nextLong());
        IntStream.range(0, k - 1).forEach(i -> initial[i][i + 1] = 0xffffffff);
        IntStream.range(0, k).forEach(i -> unit[i][i] = 0xffffffff);
        IntStream.range(0, k).forEach(i -> initial[k - 1][k - i - 1] = in.nextLong());
        IntStream.range(1, 32).forEach(i -> pows[i] = cross(pows[i - 1], pows[i - 1]));

        /* 2. CALCULATION - 1 */
        long[][] map = unit;
        for (int i = 0; i < 32; i++) {
            if (m % 2 == 1) {
                map = cross(map, pows[i]);
            }
            m /= 2;
        }

        /* 3. CALCULATION - 2 */
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans ^= map[0][i] & v[i];
        }

        /* 4. OUTPUT */
        out.println(ans);
    }

    public static long[][] cross(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] ^= a[i][k] & b[k][j];
                }
            }
        }
        return res;
    }
}
