package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CTreeDiameter {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            out.ans(n - 1).ans(1);
            for (int i = 1; i <= n; i++) {
                out.ans(i);
            }
            out.ln().flush();
            int target = in.ints();

            int min = 1, max = n;
            while (max - min > 1) {
                int mid = (min + max) / 2;
                out.ans(1).ans(mid - min).ans(n);
                for (int i = min; i < mid; i++) {
                    out.ans(i);
                }
                out.ln().flush();
                if (in.ints() == target) {
                    max = mid;
                } else {
                    min = mid;
                }
            }

            out.ans(1).ans(n - 1).ans(min);
            for (int i = 1; i <= n; i++) {
                if (i == min) continue;
                out.ans(i);
            }
            out.ln().flush();

            out.ans(-1).ans(in.ints()).ln().flush();
        }
    }
}
