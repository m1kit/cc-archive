package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DLunarNewYearAndAWander {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints(), m = in.ints();
        Queue<Integer> ans = new LinkedList<>();

        ArrayList<ArrayList<Integer>> neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neg.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = in.ints() - 1, y = in.ints() - 1;
            neg.get(x).add(y);
            neg.get(y).add(x);
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        visited[0] = true;
        q.add(0);

        while (!q.isEmpty()) {
            int orig = q.poll();
            ans.offer(orig + 1);

            ArrayList<Integer> dests = neg.get(orig);
            for (int dest : dests) {
                if (visited[dest]) {
                    continue;
                }
                visited[dest] = true;
                q.offer(dest);
            }
        }

        for (int i = 0; i < n; i++) {
            out.ans(ans.poll());
        }
        out.ln();
    }
}
