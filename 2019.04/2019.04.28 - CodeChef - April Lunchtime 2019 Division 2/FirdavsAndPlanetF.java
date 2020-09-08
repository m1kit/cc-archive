package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.Vec3i;
import dev.mikit.atcoder.lib.math.geo.Vec3l;
import dev.mikit.atcoder.lib.math.geo.g2d.Vec2i;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Comparator;

public class FirdavsAndPlanetF {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints(), q = in.ints();
            V[] vs = new V[n];
            long[] vals = new long[n];
            for (int i = 0; i < n; i++) {
                vs[i] = new V(i, in.ints());
                vals[i] = vs[i].v;
            }
            IntroSort.sort(vals);
            IntroSort.sort(vs, Comparator.comparing(v -> v.v));
            for (int i = 0; i < n; i++) {
                vs[i].rank = i;
            }
            IntroSort.sort(vs, Comparator.comparing(v -> v.index));


            for (int i = 0; i < q; i++) {
                int x = in.ints() - 1, y = in.ints() - 1;
                long min = Math.min(vs[x].v, vs[y].v);
                long max = Math.max(vs[x].v, vs[y].v);
                int d = ArrayUtil.upperBound(vals, max) - ArrayUtil.lowerBound(vals, min);
                out.ans(Math.abs(vs[x].v - vs[y].v) + y - x).ans(d).ln();
            }
        }
    }

    private static class V {
        final int index;
        int rank;
        final long v;

        V(int index, long v) {
            this.index = index;
            this.v = v;
        }
    }
}
