package jp.llv.atcoder;

import jp.llv.atcoder.lib.graph.AdjacencyMatrix;
import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.Permutation;

import java.io.PrintWriter;
import java.util.stream.IntStream;

public class DJoisinosTravel {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), m = in.ints(), r = in.ints();
        int[] d = in.ints(r);
        AdjacencyMatrix g = new AdjacencyMatrix(n);
        for (int i = 0; i < m; i++) {
            g.addEdge(in.ints() - 1, in.ints() - 1, in.ints());
        }
        g.shorten();

        int[] u = IntStream.range(0, r).toArray();
        int ans = Integer.MAX_VALUE;
        do {
            int t = 0;
            for (int i = 1; i < r; i++) {
                t += g.getWeightBetween(d[u[i - 1]] - 1, d[u[i]] - 1);
            }
            ans = Math.min(ans, t);
        } while ((u = Permutation.nextPermutation(u)) != null);
        out.println(ans);
    }
}
