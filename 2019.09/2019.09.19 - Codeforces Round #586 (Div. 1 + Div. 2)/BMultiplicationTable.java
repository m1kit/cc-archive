package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.util.Arrays;

public class BMultiplicationTable {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[][] a = in.longs(n, n);
        for (int i = 0; i < n; i++) {
            int s = i == 0 ? 1 : 0;
            int t = i == 2 ? 1 : 2;
            a[i][i] = a[i][s] * a[i][t] / a[s][t];
        }
        for (int i = 0; i < n; i++) {
            out.ans((long) Math.sqrt(a[i][i]));
        }
        out.ln();
    }
}
