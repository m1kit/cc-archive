package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.structure.UniqueEntry;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DChatInACircle {

    private static final long INF = (long) 1e12;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        IntroSort.sort(a);
        PriorityQueue<UniqueEntry<Long>> q = new PriorityQueue<>(Comparator.reverseOrder());
        q.offer(UniqueEntry.of(a[n - 1]));
        long ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            ans += q.poll().getValue();
            q.offer(UniqueEntry.of(a[i]));
            q.offer(UniqueEntry.of(a[i]));
        }
        out.ans(ans).ln();
    }
}
