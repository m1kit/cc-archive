package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class BTAKOYAKIFESTIVAL2019 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] d = in.longs(n);
        long sum = Arrays.stream(d).sum(), sum2 = Arrays.stream(d).map(x -> x * x).sum();
        out.ans((sum * sum - sum2) / 2).ln();
    }
}
