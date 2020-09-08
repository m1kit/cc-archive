package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.stream.IntStream;

public class BConstructSequences {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = IntStream.rangeClosed(1, n).map(x -> x * 30000).toArray();
        int[] b = IntStream.rangeClosed(1, n).map(x -> (n - x + 1) * 30000).toArray();
        for (int i = 0; i < n; i++) {
            a[in.ints() - 1] += i;
        }
        out.ans(a).ln().ans(b).ln();
    }
}
