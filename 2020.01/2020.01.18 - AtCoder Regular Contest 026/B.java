package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

import java.util.stream.LongStream;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long n = in.longs();
        long x = LongStream.of(IntMath.getAllDivisors(n)).sum() - n;
        if (n > x) out.ans("Deficient").ln();
        else if (n == x) out.ans("Perfect").ln();
        else out.ans("Abundant").ln();
    }
}
