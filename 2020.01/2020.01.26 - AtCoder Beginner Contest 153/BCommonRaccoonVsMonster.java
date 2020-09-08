package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.stream.IntStream;

public class BCommonRaccoonVsMonster {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int h = in.ints(), n = in.ints();
        int x = IntStream.range(0, n).map(_x -> in.ints()).sum();
        out.ans(h <= x).ln();
    }
}
