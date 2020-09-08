package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.stream.IntStream;

public class APrimeMinister {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int r = IntStream.of(a).sum() / 2 + 1;
        int sum = a[0], cnt = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] * 2 > a[0]) continue;
            sum += a[i];
            cnt++;
        }
        if (sum < r) {
            out.ans(0).ln();
        } else {
            out.ans(cnt).ln().ans(1);
            for (int i = 1; i < n; i++) {
                if (a[i] * 2 > a[0]) continue;
                out.ans(i + 1);
            }
            out.ln();
        }
    }
}
