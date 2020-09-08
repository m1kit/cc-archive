package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.euclid.LongEuclidSolver;
import dev.mikit.atcoder.lib.math.geo.Vec3l;

public class NTL_1_E {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int a = in.ints(), b = in.ints();
        Vec3l ans = LongEuclidSolver.solve(a, b);
        out.ans(ans.x).ans(ans.y).ln();
    }
}
