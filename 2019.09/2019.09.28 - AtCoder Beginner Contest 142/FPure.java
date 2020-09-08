package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FPure {

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        Node[] nodes = new Node[n];
        Node.cur = 0;
        Arrays.fill(Node.path, 0);
        int[] from = new int[m], to = new int[m];

        for (int i = 0; i < n; i++) nodes[i] = new Node(i);
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            from[i] = x;
            to[i] = y;
            nodes[x].adj.add(nodes[y]);
        }

        int[] res;
        for (int i = 0; i < n; i++) {
            if (!nodes[i].visited && (res = nodes[i].dfs()) != null) {

                int k = res.length;
                boolean[] used = new boolean[n];
                for (int value : res) used[value] = true;
                for (int j = 0; j < m; j++) {
                    if (!used[from[j]] || !used[to[j]]) continue;

                    int start = -1;
                    for (int l = 0; l < k; l++) {
                        if (res[l] == from[j]) {
                            start = l;
                            break;
                        }
                    }
                    if (res[(start + 1) % k] == to[j]) continue;

                    for (int l = 1; l < k; l++) {
                        int p = (start + l) % k;
                        if (res[p] == to[j]) break;
                        used[res[p]] = false;
                    }
                }

                int[] incnt = new int[n], outcnt = new int[n];
                for (int j = 0; j < m; j++) {
                    if (!used[from[j]] || !used[to[j]]) continue;
                    incnt[to[j]]++;
                    outcnt[from[j]]++;
                }


                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (!used[j]) continue;
                    cnt++;
                    if (incnt[j] == 0 || outcnt[j] == 0) {
                        throw new RuntimeException();
                    }
                }

                out.ans(cnt).ln();
                for (int re : res) {
                    if (!used[re]) continue;
                    out.ans(1 + re).ln();
                }
                return;
            }
        }
        out.ans(-1).ln();
    }

    private static class Node {

        private static int[] path = new int[1000];
        private static int cur;

        int index;
        List<Node> adj = new ArrayList<>();
        boolean visited = false;
        int usedAt = -1;

        Node(int index) {
            this.index = index;
        }

        int[] dfs() {
            //System.out.println("DFS " + index);
            usedAt = cur;
            path[cur++] = index;
            visited = true;
            for (Node node : adj) {
                //System.out.println("Look " + node.index + " from " + index);
                int[] res;
                if (node.usedAt >= 0) {
                    //System.out.println(Arrays.toString(path));
                    res = new int[cur - node.usedAt];
                    System.arraycopy(path, node.usedAt, res, 0, cur - node.usedAt);
                    cur = 0;
                    usedAt = -1;
                    return res;
                } else if (!node.visited) {
                    if ((res = node.dfs()) != null) {
                        usedAt = -1;
                        return res;
                    }
                }
            }
            cur--;
            usedAt = -1;
            return null;
        }
    }
}
