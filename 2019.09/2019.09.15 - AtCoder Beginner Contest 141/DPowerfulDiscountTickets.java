package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DPowerfulDiscountTickets {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        PriorityQueue<Integer> q =new PriorityQueue<>(Comparator.reverseOrder());
        int n = in.ints(), m = in.ints();
        for (int i = 0; i < n; i++) {
            q.offer(in.ints());
        }
        for (int i = 0; i < m; i++) {
            q.offer(q.poll() / 2);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += q.poll();
        }
        out.ans(ans).ln();
    }
}
