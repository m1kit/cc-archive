package jp.llv.atcoder;

import jp.llv.atcoder.lib.graph.IntAdjacencyMatrix;
import jp.llv.atcoder.lib.graph.maximumflow.MaximumFlow;
import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class C2DPlane2NPoints {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[][] r = new int[2 * n + 2][2 * n + 2];
        int[] ax = new int[n], ay = new int[n], bx = new int[n], by = new int[n];
        in.ints(ax, ay);
        in.ints(bx, by);
        for (int i = 1; i <= n; i++) {
            r[0][i] = 1;
            r[n + i][2 * n + 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ax[i] < bx[j] && ay[i] < by[j]) {
                    r[i + 1][j + n + 1] = 1;
                }
            }
        }
        int ans = 0;
        int[] path;
        while ((path = dfs(r, 0, 2 * n + 1, 0, new boolean[2 * n + 2])) != null) {
            ans++;
            for (int i = 1; i < path.length; i++) {
                r[path[i - 1]][path[i]]--;
                r[path[i]][path[i - 1]]++;
            }
        }
        out.println(ans);
    }

    private int[] dfs(int[][] graph, int start, int goal, int depth, boolean[] searched) {
        if (start == goal) {
            int[] res = new int[depth + 1];
            res[depth] = goal;
            return res;
        }
        searched[start] = true;
        for (int i = 0; i < graph.length; i++) {
            if (!searched[i] && graph[start][i] > 0) {
                int[] res = dfs(graph, i, goal, depth + 1, searched);
                if (res != null) {
                    res[depth] = start;
                    return res;
                }
            }
        }
        return null;
    }
}
