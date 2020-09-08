package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashSet;

public class BHyperset {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints();
        long[] a = new long[n];
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char[] s = in.string().toCharArray();
            for (int j = 0; j < k; j++) {
                a[i] <<= 2;
                if (s[j] == 'E') a[i] |= 1;
                else if (s[j] == 'T') a[i] |= 2;
            }
            set.add(a[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long x = a[i], y = a[j];
                long exp = 0;
                for (int l = 0; l < k; l++) {
                    if ((x & 3) == (y & 3)) exp |= (x & 3) << (2 * l);
                    else exp |= ((x ^ y ^ 3) & 3) << (2 * l);
                    x >>= 2;
                    y >>= 2;
                }
                if (set.contains(exp)) ans++;
            }
        }
        out.ans(ans / 3).ln();
    }
}
