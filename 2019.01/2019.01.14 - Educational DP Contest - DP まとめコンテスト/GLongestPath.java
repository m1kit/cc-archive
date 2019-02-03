package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GLongestPath {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();

        int n = in.ints(), m = in.ints();
        int[] depth = new int[n];
        List<List<Integer>> incoming = IntStream.range(0, n)
                .mapToObj(unused -> new ArrayList<Integer>())
                .collect(Collectors.toList());
        int[] outgoing = new int[n];
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            incoming.get(y).add(x);
            outgoing[x]++;
        }

        Debug.debug(outgoing);

        Queue<Integer> q = new LinkedList<>();
        IntStream.range(0, n)
                .filter(i -> outgoing[i] == 0)
                .forEach(q::add);// Add all leaves
        while (!q.isEmpty()) {
            int to = q.poll();
            for (Integer from : incoming.get(to)) {
                depth[from] = Math.max(depth[from], depth[to] + 1);
                if (--outgoing[from] == 0) {
                    q.add(from); // A new leaf
                }
            }
        }

        Debug.debug(depth);
        out.ans(Arrays.stream(depth).max().orElse(-1)).ln();
    }
}
