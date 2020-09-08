package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class BGoodDistance {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), d = in.ints(), ans = 0;
        int[][] x = in.ints(n, d);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long sum = 0;
                for (int k = 0; k < d; k++) {
                    sum += (x[i][k] - x[j][k]) * (x[i][k] - x[j][k]);
                }
                int sq = IntMath.sqrt(sum);
                if (sq *(long) sq == sum) {
                    ans++;
                    //System.out.println(i + " " + j);
                }
            }
        }
        out.ans(ans).ln();
    }
}
