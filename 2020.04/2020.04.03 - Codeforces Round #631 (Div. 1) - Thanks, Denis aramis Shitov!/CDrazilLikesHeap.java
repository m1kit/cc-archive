package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class CDrazilLikesHeap {

    private static final Heap FAIL = new Heap(-1, -1, false);

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        int[] ans = new int[1 << 21];
        for (int testCase = 0; testCase < testCases; testCase++) {
            // INITIALIZE ALL
            int h = in.ints(), h2 = (1 << h) - 1, g = in.ints(), g2 = (1 << g) - 1;
            long sum = 0;
            Heap[] a = new Heap[h2];
            for (int i = 0; i < h2; i++) {
                a[i] = new Heap(i, in.ints(), i >= g2);
                sum += a[i].x;
            }
            for (int i = 0; i < h2 / 2; i++) {
                a[i].l = a[i * 2 + 1];
                a[i].r = a[i * 2 + 2];
            }


            PriorityQueue<Heap> q = new PriorityQueue<>(Comparator.comparing(elm -> elm.x));
            q.offer(a[0]);
            for (int t = 0; t < h2 - g2; t++) {
                //System.out.println(q);
                Heap peek = Objects.requireNonNull(q.poll());
                int d = peek.x;
                while (peek.f(q) == FAIL) {
                    peek = Objects.requireNonNull(q.poll());
                    d = peek.x;
                }
                ans[t] = peek.index;
                sum -= d;
                q.offer(peek);
            }
            out.ans(sum).ln();
            for (int t = 0; t < h2 - g2; t++) out.ans(ans[t] + 1);
            out.ln();
        }
    }

    private static class Heap {
        int index, x;
        Heap l, r;
        boolean removable;

        Heap(int index, int x, boolean removable) {
            this.index = index;
            this.x = x;
            this.removable = removable;
        }

        Heap f(PriorityQueue<Heap> q) {
            if (l == null && r == null) {
                return this.removable ? null : FAIL;
            } else if (l == null) {
                if (pickR(q)) return this;
            } else if (r == null || l.x > r.x) {
                if (pickL(q)) return this;
            } else {
                if (pickR(q)) return this;
            }
            return FAIL;
        }

        boolean pickR(PriorityQueue<Heap> q) {
            int t = r.x;
            Heap nr = r.f(q);
            if (nr == FAIL) {
                this.removable = false;
                if (l != null) q.offer(l);
                return false;
            }
            x = t;
            r = nr;
            return true;
        }

        boolean pickL(PriorityQueue<Heap> q) {
            int t = l.x;
            Heap nl = l.f(q);
            if (nl == FAIL) {
                this.removable = false;
                if (r != null) q.offer(r);
                return false;
            }
            x = t;
            l = nl;
            return true;
        }

        @Override
        public String toString() {
            return "Heap{" +
                    "index=" + index +
                    '}';
        }
    }
}
