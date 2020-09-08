package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AThereAreTwoTypesOfBurgers {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int b = in.ints(), p1 = in.ints(), p2 = in.ints();
            int c1 = in.ints(), c2 = in.ints();
            int ans = 0;
            for (int i = 0; i <= p1; i++) {
                for (int j = 0; j <= p2; j++) {
                    if (2 * (i + j) <= b) ans = Math.max(ans, c1 * i + c2 * j);
                }
            }
            out.ans(ans).ln();
        }
    }
}
