package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.mod.ModMath;

import java.util.ArrayList;
import java.util.List;

public class FTreeAndConstraints {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        ModMath mod = new ModMath(MOD);
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i);
        for (int i = 0; i < n - 1; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            nodes[a].adj.add(new Edge(i, nodes[b]));
            nodes[b].adj.add(new Edge(i, nodes[a]));
        }
        int m = in.ints();
        long[] a = new long[m];
        for (int i = 0; i < m; i++) a[i] = nodes[in.ints() - 1].dfs(0, in.ints() - 1);
        long ans = 0;
        for (int i = 0; i < (1 << m); i++) {
            long s = (1L << (n - 1)) - 1;
            for (int j = 0; j < m; j++) if (((i >> j) & 1) == 1) s &= ~a[j];
            int free = Long.bitCount(s);
            if (Integer.bitCount(i) % 2 == 0) ans += 1L << free;
            else ans -= 1L << free;
        }
        out.ans(ans).ln();
    }

    private static class Node {
        int index;
        List<Edge> adj = new ArrayList<>();

        Node(int index) {
            this.index = index;
        }

        long dfs(long path, int dest) {
            if (dest == this.index) return path;
            long res = 0;
            for (Edge e : adj) {
                if ((path & (1L << e.index)) != 0) continue;
                res |= e.dest.dfs(path | (1L << e.index), dest);
            }
            return res;
        }
    }

    private static class Edge {
        int index;
        Node dest;

        Edge(int index, Node dest) {
            this.index = index;
            this.dest = dest;
        }
    }
}
