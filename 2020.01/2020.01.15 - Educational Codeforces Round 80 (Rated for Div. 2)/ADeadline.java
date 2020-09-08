package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ADeadline {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int testCases = in.ints();
        loop: for (int testCase = 0; testCase < testCases; testCase++) {
            long n = in.longs(), d = in.longs();
            for (long x = 0; x * x <= d; x++) {
                if (x + (d + x) / (x + 1) <= n) {
                    out.yesln();
                    continue loop;
                }
            }
            out.noln();
        }
    }
}
