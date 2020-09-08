package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class FAbsoluteMinima {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int q = in.ints();
        long b = 0;
        Tree ts = new Tree();
        for (int i = 0; i < q; i++) {
            int t = in.ints();
            if (t == 1) {
                ts.add(in.longs());
                b += in.longs();
            } else {
                long x = ts.mid();
                out.ans(x).ans(ts.min(x) + b).ln();
                //System.out.println(ts.psum + ", " + ts.qsum);
            }
        }
    }

    private static class Tree {
        PriorityQueue<Long> p = new PriorityQueue<>(Comparator.reverseOrder()), q = new PriorityQueue<>(Comparator.naturalOrder());
        long psum, qsum;

        void add(long x) {
            if (p.isEmpty() || p.peek() >= x) {
                p.offer(x);
                psum += x;
                if (!p.isEmpty() && p.size() > q.size() + 1) {
                    long y = p.poll();
                    psum -= y;
                    qsum += y;
                    q.offer(y);
                }
            } else {
                q.offer(x);
                qsum += x;
                if (q.size() > p.size()) {
                    long y = q.poll();
                    qsum -= y;
                    psum += y;
                    p.offer(y);
                }
            }
        }

        long mid() {
            assert !p.isEmpty();
            return p.peek();
        }

        long min(long d) {
            long left = p.size() * d - psum;
            long right = qsum - q.size() * d;
            return left + right;
        }
    }
}
