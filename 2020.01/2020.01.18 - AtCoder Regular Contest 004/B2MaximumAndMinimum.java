package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class B2MaximumAndMinimum {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] d = in.longs(n);
        long sum = LongStream.of(d).sum(), max = IntMath.max(d);
        out.ans(sum).ln().ans(Math.max(0, 2 * max - sum)).ln();
    }
}
