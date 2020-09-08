package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ERoadwork {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), q = in.ints();
        PriorityQueue<RoadWork> fut = new PriorityQueue<>(Comparator.comparing(w -> w.from));
        PriorityQueue<RoadWork> now = new PriorityQueue<>(Comparator.comparing(w -> w.to));
        for (int i = 0; i < n; i++) {
            int start = in.ints(), end = in.ints(), pos = in.ints();
            fut.offer(new RoadWork(start - pos, end - pos, pos));
        }

        TreeSet<Integer> pos = new TreeSet<>();
        for (int i = 0; i < q; i++) {
            int t = in.ints();
            while (!now.isEmpty() && now.peek().to <= t) {
                RoadWork w = now.poll();
                pos.remove(w.pos);
            }
            while (!fut.isEmpty() && fut.peek().from <= t) {
                RoadWork w = fut.poll();
                if (w.to > t) {
                    pos.add(w.pos);
                    now.offer(w);
                }
            }
            if (pos.isEmpty()) {
                out.ans(-1).ln();
            } else {
                out.ans(pos.first()).ln();
            }
        }
    }

    private static class RoadWork {
        int from, to, pos;

        public RoadWork(int from, int to, int pos) {
            this.from = from;
            this.to = to;
            this.pos = pos;
        }

        @Override
        public String toString() {
            return "{" +
                    "from=" + from +
                    ", to=" + to +
                    ", pos=" + pos +
                    '}';
        }
    }
}
