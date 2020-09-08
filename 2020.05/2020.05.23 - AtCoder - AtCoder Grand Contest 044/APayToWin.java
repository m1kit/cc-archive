package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class APayToWin {

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            long n = in.longs(), a = in.longs(), b = in.longs(), c = in.longs(), d = in.longs();
            minCost.clear();
            Arrays.fill(dp, -1);
            dp[0] = 0;
            out.ans(topDown(n, a, b, c, d, 0)).ln().flush();
        }
    }

    private static long[] dp = new long[1_000_000];
    private static Map<Long, Long> minCost = new HashMap<>();

    private static long bottomUp(int now, long a, long b, long c, long d) {
        if (dp[now] >= 0) return dp[now];
        long ans = now * d;
        ans = Math.min(ans, bottomUp(now / 2, a, b, c, d) + (now % 2) * d + a);
        if (now > 2) ans = Math.min(ans, bottomUp(now / 2 + 1, a, b, c, d) + (2 - now % 2) * d + a);
        ans = Math.min(ans, bottomUp(now / 3, a, b, c, d) + (now % 3) * d + b);
        if (now > 1) ans = Math.min(ans, bottomUp(now / 3 + 1, a, b, c, d) + (3 - now % 3) * d + b);
        ans = Math.min(ans, bottomUp(now / 5, a, b, c, d) + (now % 5) * d + c);
        if (now > 1) ans = Math.min(ans, bottomUp(now / 5 + 1, a, b, c, d) + (5 - now % 5) * d + c);
        return dp[now] = ans;
    }

    private static long topDown(long now, long a, long b, long c, long d, long cost) {
        if (minCost.containsKey(now) && minCost.get(now) <= cost) return Long.MAX_VALUE;
        minCost.put(now, cost);
        if (now < dp.length) {
            return bottomUp((int) now, a, b, c, d) + cost;
        }

        long ans = Math.min((Long.MAX_VALUE - cost) / d, now) * d + cost;

        ans = Math.min(ans, topDown(now / 2, a, b, c, d, cost + (now % 2) * d + a));
        if (now > 2) ans = Math.min(ans, topDown(now / 2 + 1, a, b, c, d, cost + (2 - now % 2) * d + a));

        ans = Math.min(ans, topDown(now / 3, a, b, c, d, cost + (now % 3) * d + b));
        if (now > 1) ans = Math.min(ans, topDown(now / 3 + 1, a, b, c, d, cost + (3 - now % 3) * d + b));

        ans = Math.min(ans, topDown(now / 5, a, b, c, d, cost + (now % 5) * d + c));
        if (now > 1) ans = Math.min(ans, topDown(now / 5 + 1, a, b, c, d, cost + (5 - now % 5) * d + c));
        return ans;
    }
}
