package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ATelephoneNumber {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int testCases = in.ints();
        outer: for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            String s = in.string();
            for (int i = 0; i < n - 10; i++) {
                if (s.charAt(i) == '8') {
                    out.yesln();
                    continue outer;
                }
            }
            out.noln();
        }
    }
}
