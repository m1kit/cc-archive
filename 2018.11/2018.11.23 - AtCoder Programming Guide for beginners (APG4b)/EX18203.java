package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.io.PrintWriter;
import java.util.Arrays;

public class EX18203 {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), m = in.ints();
        String[][] graph = new String[n][n];
        ArrayUtil.fill(graph, "-");
        for (int i = 0; i < m; i++) {
            int a = in.ints() - 1, b = in.ints() - 1;
            graph[a][b] = "o";
            graph[b][a] = "x";
        }
        Arrays.stream(graph)
                .map(c -> String.join(" ", c)).forEach(out::println);
    }
}
