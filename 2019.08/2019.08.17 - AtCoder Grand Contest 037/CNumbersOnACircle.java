package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CNumbersOnACircle {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n), b = in.longs(n);
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparing(i -> -b[i]));
        boolean[] done = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (a[i] > b[i]) {
                out.ans(-1).ln();
                return;
            } else if (a[i] != b[i]) q.offer(i);
            else done[i] = true;
        }
        long ans = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            long pre = b[(i + n - 1) % n], nxt = b[(i + 1) % n];
            long delta = pre + nxt;
            long dest = a[i];
            if (!done[(i + n - 1) % n]) dest = Math.max(dest, pre);
            if (!done[(i + 1) % n]) dest = Math.max(dest, nxt);

            long cnt = (b[i] - dest + delta - 1) / delta;
            //System.out.println(cnt + " ops on b[" + i + "]=" + b[i]);
            b[i] -= cnt * delta;
            ans += cnt;


            if (a[i] > b[i]) {
                out.ans(-1).ln();
                return;
            } else if (a[i] != b[i]) q.offer(i);
            else done[i] = true;
        }
        out.ans(ans).ln();
    }
}
