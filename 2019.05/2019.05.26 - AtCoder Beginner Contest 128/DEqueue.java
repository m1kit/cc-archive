package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.PriorityQueue;

public class DEqueue {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        long[] v = in.longs(n);
        PriorityQueue<Long> q = new PriorityQueue<>();
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                q.clear();
                int rem = k - (i + (n - j));
                if (rem < 0) continue;
                long val = 0;
                for (int l = 0; l < i; l++) {
                    val += v[l];
                    if (v[l] < 0) q.offer(v[l]);
                }
                for (int l = j; l < n; l++) {
                    val += v[l];
                    if (v[l] < 0) q.offer(v[l]);
                }
                while (rem > 0 && !q.isEmpty()) {
                    val -= q.poll();
                    rem--;
                }
                ans = Math.max(ans, val);
            }
        }
        out.ansln(ans);
    }
}
