package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long d = in.longs();
        long[] x = in.longs(n);


        int[] left = new int[n], right = new int[n];
        {
            int l = 0;
            for (int r = 0; r < n; r++) {
                while (x[r] - x[l] > d) {
                    l++;
                }
                left[r] = r - l;
            }
        } {
            int r = n - 1;
            for (int l = n - 1; l >= 0; l--) {
                while (x[r] - x[l] > d) {
                    r--;
                }
                right[l] = r - l;
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += left[i] * (long) right[i];
            ans -= right[i] * (right[i] - 1L) / 2;
        }
        out.ansln(ans);
    }
}
