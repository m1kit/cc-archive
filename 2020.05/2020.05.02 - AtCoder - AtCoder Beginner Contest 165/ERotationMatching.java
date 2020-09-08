package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ERotationMatching {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        for (int i = 0; i < m / 2; i++) out.ans(i + 1).ans(m / 2 * 2 + 1 - i).ln();
        for (int i = 0; i < (m + 1) / 2; i++) out.ans(m / 2 * 2 + 2 + i).ans(2 * m + 1 - i).ln();
    }
}
