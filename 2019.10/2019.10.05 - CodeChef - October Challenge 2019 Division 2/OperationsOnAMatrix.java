package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class OperationsOnAMatrix {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints(), m = in.ints(), q = in.ints();
            int[] r = new int[n], c = new int[m];
            for (int i = 0; i < q; i++) {
                r[in.ints() - 1]++;
                c[in.ints() - 1]++;
            }
            int odd1 = 0, odd2 = 0;
            for (int i = 0; i < n; i++) {
                if (r[i] % 2 == 1) odd1++;
            }
            for (int i = 0; i < m; i++) {
                if (c[i] % 2 == 1) odd2++;
            }
            out.ans(odd1 * (long) (m - odd2) + (n - odd1) * (long) odd2).ln();
        }
    }
}
