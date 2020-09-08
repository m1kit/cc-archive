package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BPickingBalls {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        List<Integer> r = new ArrayList<>(), b = new ArrayList<>();
        int n = in.ints();
        for (int i = 0; i < n; i++) {
            int x = in.ints();
            char c = in.chars()[0];
            if (c == 'R') r.add(x);
            else b.add(x);
        }
        r.sort(Comparator.naturalOrder());
        b.sort(Comparator.naturalOrder());
        for (int x : r) out.ans(x).ln();
        for (int x : b) out.ans(x).ln();
    }
}
