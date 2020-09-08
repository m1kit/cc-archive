package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class Attendance {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            String[] p = new String[n], q = new String[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.string();
                q[i] = in.string();
            }
            outer: for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && p[i].equals(p[j])) {
                        out.ans(p[i]).ans(q[i]).ln();
                        continue outer;
                    }
                }
                out.ans(p[i]).ln();
            }
        }
    }
}
