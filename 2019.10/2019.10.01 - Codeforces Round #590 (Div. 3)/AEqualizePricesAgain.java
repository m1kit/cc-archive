package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.stream.IntStream;

public class AEqualizePricesAgain {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int queries = in.ints();
        for (int query = 0; query < queries; query++) {
            int n = in.ints();
            long sum = IntStream.range(0, n).map(x -> in.ints()).sum();
            out.ans((sum + n - 1) / n).ln();
        }
    }
}
