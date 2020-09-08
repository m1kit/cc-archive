package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.euclid.LongEuclidSolver;
import dev.mikit.atcoder.lib.math.geo.Vec3l;

public class GolfGophers {

    private static final int COURSES = 18;
    private static final int[] MOD = {5, 7, 11, 13, 17, 18};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints(), n = in.ints(), m = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int[] a = new int[MOD.length];
            for (int i = 0; i < MOD.length; i++) {
                for (int j = 0; j < 18; j++) {
                    out.ans(MOD[i]);
                }
                out.ln().flush();
                for (int j = 0; j < 18; j++) {
                    a[i] += in.ints();
                }
                a[i] %= MOD[i];
            }
            long ans = 0;
            long mod = 1;
            for (int i = 0; i < MOD.length; i++) {
                Vec3l sol = LongEuclidSolver.solve(mod, MOD[i]);
                long mm = mod * MOD[i];
                long na = (ans * sol.y) % mm * MOD[i] % mm;
                na += (a[i] * sol.x) % mm * mod % mm;
                na %= mm;
                ans = na;
                mod = mm;
            }
            out.ans(ans).ln().flush();
            int verdict = in.ints();
            if (verdict == -1) {
                return;
            }
        }
    }
}
