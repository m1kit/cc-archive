package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CGasPipeline {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            long a = in.longs(), b = in.longs();
            String s = in.string();
            long ans = n * a + (n + 1) * b;
            int last = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') continue;
                long cost = 2 * a;
                if (last != -1) cost = Math.min(cost, Math.max(0, i - last - 1) * b);
                if (last != i) ans += b;
                ans += b;
                ans += cost;
                last = i + 1;
            }
            out.ans(ans).ln();
        }
    }
}
