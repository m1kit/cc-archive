package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.mod.ModMath;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBeautifulGraph {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = 998244353;
    private static long[] c = new long[2];

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int t = in.ints();
        ModMath mod = new ModMath(MOD);
        outer: for (int testCase = 0; testCase < t; testCase++) {
            int n = in.ints(), m = in.ints();
            N[] ns = new N[n];
            for (int i = 0; i < n; i++) {
                ns[i] = new N();
            }
            for (int i = 0; i < m; i++) {
                int x = in.ints() - 1, y = in.ints()  - 1;
                ns[x].list.add(ns[y]);
                ns[y].list.add(ns[x]);
            }
            long ans = 1;
            for (int i = 0; i < n; i++) {
                if (ns[i].w == 0) {
                    c[0] = 0;
                    c[1] = 0;
                    if (!dfs(ns[i], true)) {
                        out.println(0);
                        continue outer;
                    } else {
                        long ws = c[0];
                        long nws = c[1];
                        ans *= (mod.pow(2, ws) + mod.pow(2, nws)) % MOD;
                        ans %= MOD;
                    }
                }
            }
            out.println(ans);
        }
    }

    private static class N {
        private List<N> list = new ArrayList<>();
        private int w = 0;
    }

    public static boolean dfs(N n, boolean even) {
        if (n.w > 0) {
            return (n.w == 2) == even;
        }
        n.w = even ? 2 : 1;
        c[even ? 0 : 1]++;
        for (N t : n.list) {
            if (!dfs(t, !even)) {
                return false;
            }
        }
        return true;
    }

}
