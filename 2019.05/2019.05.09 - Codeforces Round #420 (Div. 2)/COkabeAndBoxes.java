package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.PriorityQueue;

public class COkabeAndBoxes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int ans = 0;
        int min = n + 1;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < 2 * n; i++) {
            String op = in.string();
            if ("add".equals(op)) {
                int a = in.ints();
                if (!q.isEmpty() && q.peek() < a) {
                    min = Math.min(min, q.peek());
                }
                q.offer(a);
            } else {
                if (q.isEmpty()) throw new RuntimeException();
                if (min == q.peek()) {
                    ans++;
                    min = n + 1;
                }
                q.poll();
            }
        }
        out.ans(ans).ln();
    }
}
