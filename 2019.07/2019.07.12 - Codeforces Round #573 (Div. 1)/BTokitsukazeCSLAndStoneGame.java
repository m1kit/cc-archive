package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class BTokitsukazeCSLAndStoneGame {

    private static final String FIRST = "sjfnb", SECOND = "cslnb";

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] a = in.longs(n);
        if (n == 1) {
            out.ans(a[0] % 2 == 0 ? SECOND : FIRST).ln();
            return;
        }
        IntroSort.sort(a);
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == a[i + 1]) {
                cnt++;
                if (0 < i && a[i - 1] + 1 == a[i]) {
                    out.ans(SECOND).ln();
                    return;
                }
            }
        }
        if (cnt > 1 || a[1] == 0) {
            out.ans(SECOND).ln();
            return;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] - i;
        }
        out.ans(sum % 2 == 1 ? FIRST : SECOND).ln();
    }
}
