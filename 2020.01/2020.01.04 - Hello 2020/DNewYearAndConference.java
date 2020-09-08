package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;

import java.util.Arrays;
import java.util.Comparator;

public class DNewYearAndConference {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints();
        Event[] events = new Event[n];
        for (int i = 0; i < n; i++) events[i] = new Event(in.longs(), in.longs(), in.longs(), in.longs());
        if (solve(n, events)) {
            out.noln();
            return;
        }
        for (int j = 0; j < n; j++) events[j].swap();
        if (solve(n, events)) {
            out.noln();
            return;
        }
        out.yesln();
    }

    static boolean solve(int n, Event[] events) {
        Event[] starts = events.clone(), ends = events.clone();
        IntroSort.sort(starts, Comparator.comparing(event -> event.s1));
        IntroSort.sort(ends, Comparator.comparing(event -> event.e1));

        for (int j = 0; j < n; j++) ends[j].index = j;

        IntSegmentTree min, max;
        {
            max = new IntSegmentTree(new long[n + 1], Math::max, -1, (x, u) -> u);
            long[] tmp = new long[n + 1];
            Arrays.fill(tmp, Long.MAX_VALUE);
            min = new IntSegmentTree(tmp, Math::min, Long.MAX_VALUE, (x, u) -> u);
        }

        int cur = 0;
        for (int i = 0; i < n; i++) {
            while (cur < n && starts[cur].s1 <= ends[i].e1) {
                max.update(starts[cur].index, starts[cur].s2);
                min.update(starts[cur].index, starts[cur].e2);
                cur++;
            }

            int ok = 0, ng = n;
            while (ng - ok > 1) {
                int mid = (ng + ok) / 2;
                if (ends[i].s1 <= ends[mid].e1) ng = mid;
                else ok = mid;
            }

            long maxStart = max.query(ng, n), minEnd = min.query(ng, n);
            if (ends[i].e2 < maxStart || minEnd < ends[i].s2) {
                return true;
            }
        }
        return false;
    }

    private static class Event {
        long s1, e1, s2, e2;
        int index;

        Event(long s1, long e1, long s2, long e2) {
            this.s1 = s1;
            this.e1 = e1;
            this.s2 = s2;
            this.e2 = e2;
        }

        void swap() {
            long t = s1;
            s1 = s2;
            s2 = t;

            t = e1;
            e1 = e2;
            e2 = t;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "s1=" + s1 +
                    ", e1=" + e1 +
                    ", s2=" + s2 +
                    ", e2=" + e2 +
                    ", index=" + index +
                    '}';
        }
    }
}
