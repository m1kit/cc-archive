package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.Factorial;
import dev.mikit.atcoder.lib.math.mod.ModMath;
import sun.nio.cs.ext.MacThai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B123Triangle {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] s = in.string().chars().map(c -> c - '0').toArray();
        for (int i = 0; i < 10 && n > 1; i++) {
            n--;
            for (int j = 0; j < n; j++) {
                s[j] = Math.abs(s[j] - s[j + 1]);
            }
        }
        if (n == 1) {
            out.ans(s[0]).ln();
            return;
        }

        int coeff = 2;
        for (int i = 0; i < n; i++) {
            if ((s[i] & 1) == 1) coeff = 1;
        }
        if (coeff == 2) {
            for (int i = 0; i < n; i++) {
                s[i] >>= 1;
            }
        }

        int p = 0;
        for (int i = 0; i < n; i++) if ((i & (n - i - 1)) == 0) p += s[i] & 1;
        p &= 1;
        out.ans(p * coeff).ln();
    }
}
