package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class BBuffet {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n), b = in.ints(n), c = in.ints(n - 1);
        int ans = Arrays.stream(b).sum();
        for (int i = 0; i < n - 1; i++) {
            if (a[i] + 1== a[i + 1]) ans += c[a[i] - 1];
        }
        out.ans(ans).ln();
    }
}
