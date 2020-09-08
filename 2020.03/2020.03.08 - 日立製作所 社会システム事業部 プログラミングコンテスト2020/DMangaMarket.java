package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DMangaMarket {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long t = in.longs();
        List<Long> constant = new ArrayList<>();
        List<Store> dynamic = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long a = in.longs(), b = in.longs();
            if (a == 0) constant.add(b + 1);
            else dynamic.add(new Store(a, b));
        }
        constant.sort(Comparator.naturalOrder());
        dynamic.sort(Comparator.reverseOrder());
        n = dynamic.size();

        long[][] dp = new long[30][n + 1];
        ArrayUtil.fill(dp, t + 10);
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            Store store = dynamic.get(i);
            for (int j = 0; j < 30; j++) dp[j][i + 1] = dp[j][i];
            for (int j = 0; j < 29; j++) {
                long d = (dp[j][i] + 1) * store.a + store.b;
                if (dp[j][i] + d > t) continue;
                dp[j + 1][i + 1] = Math.min(dp[j + 1][i + 1], dp[j][i] + d);
            }
        }
        int ans = 0;
        for (int i = 0; i < 30; i++) {
            if (dp[i][n] > t) continue;
            long room = t - dp[i][n];
            int cnt = i;
            for (long x : constant) {
                if (x <= room) {
                    room -= x;
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        out.ans(ans).ln();
    }

    private static class Store implements Comparable<Store> {
        long a, b;

        Store(long a, long b) {
            this.a = a;
            this.b = b + 1;
        }

        @Override
        public int compareTo(Store o) {
            return Long.compare(a * o.b, o.a * b);
        }
    }
}
