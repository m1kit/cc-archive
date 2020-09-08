package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DPredictionAndRestriction {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints();
        int[] a = in.ints(3);
        char[] s = in.string().toCharArray();
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += a[index(s[i])];
            for (int j = k + i; j < n; j += k) {
                if (s[j - k] == s[j]) s[j] = '*';
                else ans += a[index(s[j])];
            }
        }
        out.ans(ans).ln();
    }

    private static int index(char c) {
        switch (c) {
            case 'r':
                return 2;
            case 's':
                return 0;
            case 'p':
                return 1;
        }
        throw new RuntimeException();
    }
}
