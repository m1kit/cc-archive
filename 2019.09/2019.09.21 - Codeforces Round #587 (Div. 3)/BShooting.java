package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class BShooting {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Can[] cans = new Can[n];
        for (int i = 0; i < n; i++) {
            cans[i] = new Can(i + 1, in.longs());
        }
        IntroSort.sort(cans, Comparator.comparing(can -> -can.cost));
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += cans[i].cost * i + 1;
        }
        out.ans(ans).ln();
        for (int i = 0; i < n; i++) {
            out.ans(cans[i].index);
        }
        out.ln();
    }

    private static class Can {
        int index;
        long cost;

        Can(int index, long cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
