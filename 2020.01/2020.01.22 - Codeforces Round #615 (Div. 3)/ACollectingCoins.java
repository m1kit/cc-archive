package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ACollectingCoins {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            long a = in.longs(), b = in.longs(), c = in.longs(), n = in.longs();
            long t = a + b + c + n;
            if (t % 3 != 0) {
                out.noln();
            } else {
                t /= 3;
                if (t < a || t < b || t < c) out.noln();
                else out.yesln();
            }
        }
    }
}
