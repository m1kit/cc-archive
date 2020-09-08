package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ArrayModification {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            long k = in.longs();
            int[] a = in.ints(n);
            for (int i = 0; i < n / 2; i++) {
                long cnt = k / n * 2;
                if (i < k % n) cnt++;
                if (n - i - 1 < k % n) cnt++;
                cnt %= 6;
                for (int j = 0; j < cnt; j++) {
                    if (j % 2 == 0) {
                        a[i] ^= a[n - i - 1];
                    } else {
                        a[n - i - 1] ^= a[i];
                    }
                }
            }
            if (n % 2 == 1 && n / 2 + 1 <= k) a[n / 2] = 0;
            out.ans(a).ln();
        }
    }
}
