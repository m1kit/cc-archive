package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.function.IntToLongFunction;

public class DMovingPiece {

    private static final int MOD = (int) 1e9 + 7;
    static int n;
    static int[][] p;
    static long[][] c;
    static int retNow;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        n = in.ints();
        p = new int[n][30];
        c = new long[n][30];
        long k = in.longs();
        for (int i = 0; i < n; i++) p[i][0] = in.ints() - 1;
        long[] c0 = in.longs(n);
        for (int i = 0; i < n; i++) c[i][0] = c0[p[i][0]];
        for (int i = 1; i < 30; i++) {
            for (int j = 0; j < n; j++) {
                int t = p[j][i - 1];
                p[j][i] = p[t][i - 1];
                c[j][i] = c[j][i - 1] + c[t][i - 1];
            }
        }

        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int now = i;
            long res = 0;
            for (int j = 0; j < Math.min(n, k); j++) {
                res += c[now][0];
                now = p[now][0];
                ans = Math.max(ans, res);
            }

            long start = Math.max(0, k - n);
            res = sum(i, start);
            now = retNow;
            for (long j = start; j < k; j++) {
                res += c[now][0];
                now = p[now][0];
                ans = Math.max(ans, res);
            }
        }
        out.ans(ans).ln();
    }

    private static long sum(int now, long k) {
        if (k == 0) {
            retNow = now;
            return 0;
        }
        if (k < 0) throw new IllegalArgumentException();
        long res = 0;
        for (int j = 29; j >= 0; j--) {
            if (((1L << j) & k) == 0) continue;
            res += c[now][j];
            now = p[now][j];
        }
        retNow = now;
        return res;
    }
}
