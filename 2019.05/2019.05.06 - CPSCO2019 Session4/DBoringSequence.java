package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DBoringSequence {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        int[] a = in.ints(n);

        PriorityQueue<Seg> q = new PriorityQueue<Seg>(Comparator.comparing(s -> -s.max()));

        {
            int last = a[0];
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (a[i] == last) {
                    cnt++;
                } else {
                    q.offer(new Seg(cnt));
                    last = a[i];
                    cnt = 1;
                }
            }
            q.offer(new Seg(cnt));
        }

        for (int i = 0; i < k; i++) {
            if (q.peek().max() == 1) break;
            Seg p = q.poll();
            p.spl++;
            q.offer(p);
        }

        //System.out.println(q);
        out.ans(q.peek().max()).ln();
    }

    private static class Seg {
        int cnt;
        int spl;

        public Seg(int cnt) {
            this.cnt = cnt;
        }

        int max() {
            int b = cnt - spl;
            return (b + spl) / (spl + 1);
        }
    }
}
