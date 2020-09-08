package dev.mikit.atcoder;

import java.util.*;

public class TwoLadders {
    private static final long INF = 10_000_000_000_000_000L;

    public long minSteps(int sx, int lx1, int lx2, int[] X, int[] Y) {
        int n = X.length;
        long[] lx = {sx, lx1, lx2};
        Coin[] coins = new Coin[n];
        for (int i = 0; i < n; i++) {
            coins[i] = new Coin(X[i], Y[i]);
        }
        Collections.shuffle(Arrays.asList(coins));
        Arrays.sort(coins, Comparator.comparing(coin -> coin.y));

        int cur = 0;
        long[] dp = {0, Math.abs(sx - lx1), Math.abs(sx - lx2)};
        long preh = 0;
        while (true) {
            long height = coins[cur].y;
            long base = height - preh;
            preh = height;
            long min = INF, max = -INF;
            while (cur < n && height == coins[cur].y) {
                min = Math.min(min, coins[cur].x);
                max = Math.max(max, coins[cur].x);
                cur++;
            }
            if (cur == n) {
                long res = INF;
                for (int i = (height == 0 ? 0 : 1); i <= 2; i++) {
                    long cost;
                    if (lx[i] < min) {
                        cost = dp[i] + max - lx[i];
                    } else if (max < lx[i]) {
                        cost = dp[i] + lx[i] - min;
                    } else {
                        cost = dp[i] + max - min + Math.min(lx[i] - min, max - lx[i]);
                    }
                    res = Math.min(cost, res);
                }
                return base + res;
            }

            long[] upd = {INF, INF, INF};
            for (int orig = (height == 0 ? 0 : 1); orig <= 2; orig++) {
                for (int dest = 1; dest <= 2; dest++) {
                    long cost = dp[orig] + base + max(max, lx[orig], lx[dest]) - min(min, lx[orig], lx[dest])
                            + Math.max(0, max - Math.max(lx[orig], lx[dest])) + Math.max(0, Math.min(lx[orig], lx[dest]) - min);
                    upd[dest] = Math.min(upd[dest], cost);
                }
            }
            dp = upd;
        }
    }

    static class Coin {
        long x, y;

        Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static long max(long x, long y, long z) {
        return Math.max(Math.max(x, y), z);
    }

    private static long min(long x, long y, long z) {
        return Math.min(Math.min(x, y), z);
    }
}
