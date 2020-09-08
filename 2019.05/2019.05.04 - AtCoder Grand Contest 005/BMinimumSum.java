package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2i;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.TreeSet;

public class BMinimumSum {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        Vec2i[] a = new Vec2i[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Vec2i(in.ints(), i);
        }

        IntroSort.sort(a);
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(-1);
        ts.add(n);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int idx = a[i].y;
            int left = ts.lower(idx), right = ts.higher(idx);
            long cnt = (right - idx) * (long) (idx - left);
            //System.out.println(i + ":" + cnt);
            ans += cnt * a[i].x;
            ts.add(idx);
        }
        out.ans(ans).ln();
    }
}
