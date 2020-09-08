package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.ArrayList;
import java.util.List;

public class C2BalancedRemovalsHarder {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        P[] ps = new P[n];
        for (int i = 0; i < n; i++) {
            ps[i] = new P(i + 1, in.ints(), in.ints(), in.ints());
        }
        IntroSort.sort(ps);
        for (int i = 1; i < n; i++) {
            if (ps[i - 1].x == ps[i].x && ps[i - 1].y == ps[i].y) {
                out.ans(ps[i - 1].index).ans(ps[i].index).ln();
                ps[i - 1].used = ps[i].used = true;
                i++;
            }
        }
        {
            int cur = 0;
            for (int i = 0; i < n; i++) {
                if (ps[i].used) continue;
                ps[cur++] = ps[i];
            }
            n = cur;
        }

        for (int i = 1; i < n; i++) {
            if (ps[i - 1].x == ps[i].x) {
                out.ans(ps[i - 1].index).ans(ps[i].index).ln();
                ps[i - 1].used = ps[i].used = true;
                i++;
            }
        }
        {
            int cur = 0;
            for (int i = 0; i < n; i++) {
                if (ps[i].used) continue;
                ps[cur++] = ps[i];
            }
            n = cur;
        }

        for (int i = 0; i < n; i += 2) {
            out.ans(ps[i].index).ans(ps[i + 1].index).ln();
        }
    }

    private static class P implements Comparable<P> {
        int index;
        int x, y, z;
        boolean used = false;

        P(int index, int x, int y, int z) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        int dist(P o) {
            return Math.abs(x - o.x) + Math.abs(y - o.y) + Math.abs(z - o.z);
        }

        @Override
        public int compareTo(P o) {
            if (x != o.x) return Integer.compare(x, o.x);
            if (y != o.y) return Integer.compare(y, o.y);
            return Integer.compare(z, o.z);
        }
    }
}
