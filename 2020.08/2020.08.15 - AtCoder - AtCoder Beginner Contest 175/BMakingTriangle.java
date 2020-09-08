package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class BMakingTriangle {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int ans = 0;
        long[] a = in.longs(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    //Arrays.sort(x);
                    if (a[i] == a[j] || a[j] == a[k] || a[k] == a[i]) continue;
                    
                    if (a[i] + a[j] <= a[k]) continue;
                    if (a[j] + a[k] <= a[i]) continue;
                    if (a[k] + a[i] <= a[j]) continue;
                    ans++;
                }
            }
        }
        out.ans(ans).ln();
    }

}
