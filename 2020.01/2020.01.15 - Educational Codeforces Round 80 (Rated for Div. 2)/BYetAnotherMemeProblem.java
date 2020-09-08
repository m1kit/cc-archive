package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BYetAnotherMemeProblem {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            long a = in.longs(), b = in.longs();
            long ans = 0;
            //a*(b+1)=a*10^k
            for (long i = 9; i <= b; i = i * 10 + 9) {
                ans += a;
            }
            out.ans(ans).ln();
        }
    }
}
