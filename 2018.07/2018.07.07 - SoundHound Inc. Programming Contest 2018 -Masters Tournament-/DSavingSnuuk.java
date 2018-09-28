package jp.llv.atcoder;

import java.util.*;
import java.io.PrintWriter;

public class DSavingSnuuk {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt(), s = in.nextInt() - 1, t = in.nextInt() - 1;

        // neighbour ベーカリー
        // どんどん隣人を焼いていこう
        Pair[][] neig = new Pair[n][];
        int[] nc = new int[n];
        for (int i = 0; i < n; i++) {
            neig[i] = new Pair[n];
        }


        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt();
            int a = in.nextInt(), b = in.nextInt();
            neig[x - 1][nc[x - 1]] = new Pair(y - 1, a, b);
            nc[x - 1]++;
            neig[y - 1][nc[y - 1]] = new Pair(x - 1, a, b);
            nc[y - 1]++;
        }
        long[] jpy = new long[n], snk = new long[n];
        d(neig, s, jpy, 0);
        d(neig, t, snk, 1);
        long min = Long.MAX_VALUE;
        long[] ans = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, jpy[i] + snk[i]);
            ans[i] = min;
        }
        for (long oneofans : ans) {
            out.println(1000000000000000L - oneofans);
        }
    }

    private static void d(Pair[][] d, int s, long[] dist, int ci) {
        boolean[] f = new boolean[dist.length];
        for (int i = 0; i < f.length; i++) {
            dist[i] = Long.MAX_VALUE;
            f[i] = false;
        }
        dist[s] = 0;
        Queue<Integer> todo = new PriorityQueue<>(Comparator.comparing(i -> -dist[i]));
        todo.add(s);
        while (!todo.isEmpty()) {
            int m = todo.remove();
            if (f[m]) {
                continue;
            }
            f[m] = true;
            for (Pair p : d[m]) {
                if (p == null) {
                    break;
                }
                int t = p.n;
                long nd = dist[m] + p.c[ci];
                if (dist[t] > nd) {
                    dist[t] = nd;
                    todo.add(t);
                }
            }
        }
    }

    private static class Pair {
        int n;
        int[] c = new int[2];//0 JPY 1 SNK
        private Pair(int n, int c1, int c2) {
            this.n = n;
            this.c[0] = c1;
            this.c[1] = c2;
        }
        // Pairじゃねえ
    }
}
