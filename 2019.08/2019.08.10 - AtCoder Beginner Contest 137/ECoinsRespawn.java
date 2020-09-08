package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.graph.shortestpath.BellmanFord;
import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.*;

public class ECoinsRespawn {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints(), p = in.ints();
        BellmanFord bf = new BellmanFord(n);
        for (int i = 0; i < m; i++) {
            bf.addEdge(in.ints() - 1, in.ints() - 1, p - in.ints());
        }
        try {
            out.ans(Math.max(0L, -bf.shortestPath(0, n - 1))).ln();
        } catch (RuntimeException ex) {
            out.ans(-1).ln();
        }
    }
}
