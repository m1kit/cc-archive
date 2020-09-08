package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.*;

public class BGoodTriple {

    private static final int MOD = (int) 1e9 + 7;
    private static final String[] TOKEN = {
            "000", "111", "01010", "10101", "0**0**0", "1**1**1", "0*1*0*1*0", "1*0*1*0*1",
    };

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int n = s.length();
        boolean[] found = new boolean[n];
        PriorityQueue<Segment> segments = new PriorityQueue<>();
        TreeSet<Integer> ends = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (String token : TOKEN) {
            int m = token.length();
            outer:
            for (int i = 0; i <= n - m; i++) {
                if (found[i]) continue;
                for (int j = 0; j < m; j++) {
                    if (token.charAt(j) != '*' && s.charAt(i + j) != token.charAt(j)) continue outer;
                }
                segments.offer(new Segment(i, i + m));
                ends.add(i + m);
                map.merge(i + m, 1, Integer::sum);
                found[i] = true;
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            while (!segments.isEmpty() && segments.peek().from < i) {
                Segment invalid = segments.poll();
                map.merge(invalid.to, -1, Integer::sum);
                if (map.get(invalid.to) == 0) ends.remove(invalid.to);
            }
            if (!ends.isEmpty()) {
                ans += n - ends.first() + 1L;
                //System.out.println("i=" + i + ", " + (n - ends.first() + 1L));
            }
        }
        out.ans(ans).ln();
    }

    private static class Segment implements Comparable<Segment> {
        int from, to;

        public Segment(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "Segment{" +
                    "from=" + from +
                    ", to=" + to +
                    '}';
        }

        @Override
        public int compareTo(Segment o) {
            return this.from - o.from;
        }
    }
}
