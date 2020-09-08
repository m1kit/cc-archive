package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Comparator;
import java.util.PriorityQueue;

public class EToughJourney {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        long[] a = in.longs(n);

        PriorityQueue<Store> q = new PriorityQueue<>(Comparator.comparing(store -> store.price));
        long ans = 0;
        for (int i = 0; i < n; i++) {
            q.offer(new Store(i, a[i]));
            while (i - q.peek().index >= k) q.poll();
            ans += q.peek().price;
        }
        out.ans(ans).ln();
    }

    private static class Store {
        int index;
        long price;

        Store(int index, long price) {
            this.index = index;
            this.price = price;
        }
    }
}
