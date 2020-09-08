package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.unionfindtree.IntUnionFind;

import java.util.*;

public class AStringTransformation1 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        outer:
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints();
            char[] s = in.chars(), t = in.chars();
            int[][] a = new int[20][20];
            for (int i = 0; i < n; i++) {
                if (s[i] > t[i]) {
                    out.ans(-1).ln();
                    continue outer;
                } else if (s[i] == t[i]) continue;
                a[s[i] - 'a'][t[i] - 'a']++;
            }

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if (a[i][j] > 0) edges.add(new Edge(i, j));
                }
            }
            n = edges.size();

            IntUnionFind uf = new IntUnionFind(n);
            List<Set<Integer>> sep = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sep.add(new HashSet<>());
                for (int j = 0; j < i; j++) {
                    Edge x = edges.get(i), y = edges.get(j);
                    if (x.s == y.s || x.t == y.t || x.s == y.t || x.t == y.s) uf.union(i, j);
                }
            }
            for (int i = 0; i < n; i++) {
                Set<Integer> ss = sep.get(uf.find(i));
                Edge e = edges.get(i);
                ss.add(e.s);
                ss.add(e.t);
            }
            int ans = 0;
            for (Set<Integer> ss : sep) {
                if (ss.isEmpty()) continue;
                ans += ss.size() - 1;
            }
            out.ans(ans).ln();

            /*
            PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparing(edge -> edge.t - edge.s));
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if (a[i][j] > 0) edges.offer(new Edge(i, j));
                }
            }
            boolean[][] d = new boolean[20][20];
            int ans = 0;
            while (!edges.isEmpty()) {
                Edge e = edges.poll();
                if (d[e.s][e.t]) continue;
                ans++;
                d[e.s][e.t] = true;
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 20; j++) {
                        for (int k = 0; k < 20; k++) {
                            d[j][k] |= d[j][i] && d[i][k];
                        }
                    }
                }
            }*/
            //out.ans(ans).ln();
        }
    }

    private static class Edge {
        int s, t;

        Edge(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
}
