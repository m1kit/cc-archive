package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;

public class DCandidatesOfNoShortestPaths {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), m = in.ints();
        ShortestPathSolver solver = ShortestPathSolver.Algorithm.WARSHALL_FLOYD.getInstance(n);
        int[] a = new int[m];
        int[] b = new int[m];
        int[] c = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = in.ints() - 1;
            b[i] = in.ints() - 1;
            c[i] = in.ints();
            solver.addEdge(a[i], b[i], c[i]);
            solver.addEdge(b[i], a[i], c[i]);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (c[i] > solver.shortestPath(a[i], b[i])) {
                ans++;
            }
        }
        out.println(ans);
    }
}
