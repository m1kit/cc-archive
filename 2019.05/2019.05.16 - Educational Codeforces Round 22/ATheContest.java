package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.stream.IntStream;

public class ATheContest {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int sum = IntStream.of(a).sum();
        int m = in.ints();
        for (int i = 0; i < m; i++) {
            int l = in.ints(), r = in.ints();
            if (l <= sum && sum <= r) {
                out.ans(sum).ln();
                return;
            } else if (sum < l) {
                out.ans(l).ln();
                return;
            }
        }
        out.ans(-1).ln();
    }
}
