package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(), q = in.ints();
        List<ArrayList<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        int[] c = in.ints(n);
        for (int i = 0; i < q; i++) {
            if (in.ints() == 1) {
                int x = in.ints() - 1;
                out.ans(c[x]).ln();
                for (int nxt : adj.get(x)) c[nxt] = c[x];
            } else {
                int x = in.ints() - 1, y = in.ints();
                out.ans(c[x]).ln();
                c[x] = y;
            }
        }
    }
}
