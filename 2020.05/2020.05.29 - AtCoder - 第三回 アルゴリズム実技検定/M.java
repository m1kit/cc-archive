package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.*;

public class M {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        List<List<Integer>> nodes = new ArrayList<>(n);
        for (int i = 0; i < n; i++) nodes.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            nodes.get(x).add(y);
            nodes.get(y).add(x);
        }
        int s = in.ints() - 1, k = in.ints();
        int[] a = new int[k + 1];
        a[k] = s;
        for (int i = 0; i < k; i++) a[i] = in.ints() - 1;
        int[][] dist = new int[k + 1][n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dist[i], -1);
            dist[i][a[i]] = 0;
            q.offer(a[i]);
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int next : nodes.get(now)) {
                    if (dist[i][next] >= 0) continue;
                    dist[i][next] = dist[i][now] + 1;
                    q.offer(next);
                }
            }
        }

        int[][] dp = new int[k + 1][1 << k];
        ArrayUtil.fill(dp, 1_000_000_000);
        dp[k][0] = 0;
        for (int i = 0; i < (1 << k); i++) {
            for (int from = 0; from <= k; from++) {
                if (from != k && ((i >> from) & 1) == 0) continue;
                for (int to = 0; to < k; to++) {
                    if (((i >> to) & 1) == 1) continue;
                    int f = i | (1 << to);
                    dp[to][f] = Math.min(dp[to][f], dp[from][i] + dist[from][a[to]]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ans = Math.min(ans, dp[i][(1 << k) - 1]);
        }
        out.ans(ans).ln();
    }
}
