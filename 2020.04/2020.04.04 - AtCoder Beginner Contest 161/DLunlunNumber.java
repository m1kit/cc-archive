package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.*;

public class DLunlunNumber {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int k = in.ints();
        HashSet<Long> t = new HashSet<>();
        //int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            //a[0] = i;
            dfs(i, 1, t);
        }
        long[] ans = t.stream().mapToLong(x -> x).sorted().toArray();
        out.ans(ans[k]).ln();
    }

    private static void dfs(long now, long k, HashSet<Long> ans) {
        if (k >= 10_000_000_000L) return;
        ans.add(now);
        long d = now / k, nk = k * 10;
        dfs(now + d * nk, nk, ans);
        //ans.add(now + d * nk);
        if (d >= 1) {
            long down = now + (d - 1) * nk;
            dfs(down, nk, ans);
        }
        if (d < 9) {
            long up = now + (d + 1) * nk;
            dfs(up, nk, ans);
        }
    }
}
