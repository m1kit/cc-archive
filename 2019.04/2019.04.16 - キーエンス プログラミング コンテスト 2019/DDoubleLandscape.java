package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.geo.Vec3i;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;
import java.util.Comparator;

public class DDoubleLandscape {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int[] a = in.ints(n), b = in.ints(m);
        int[] r = new int[n * m + 1], c = new int[n * m + 1];
        Arrays.fill(r, -1);
        Arrays.fill(c, -1);
        for (int i = 0; i < n; i++) {
            r[a[i]] = i;
        }
        for (int i = 0; i < m; i++) {
            c[b[i]] = i;
        }

        int h = 0, w = 0;
        long ans = 1;
        for (int i = n * m; i > 0; i--) {
            if (r[i] >= 0 && c[i] >= 0) {
                h++;
                w++;
            } else if (r[i] >= 0) {
                h++;
                ans *= w;
                ans %= MOD;
            } else if (c[i] >= 0) {
                w++;
                ans *= h;
                ans %= MOD;
            } else {
                ans *= (w * h) - (n * m - i);
                ans %= MOD;
            }
        }
        out.ansln(ans);
    }

}
