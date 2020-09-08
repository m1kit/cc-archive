package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.stream.IntStream;

public class BAchieveTheGoal {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        int x = in.ints() * n - IntStream.range(1, n).map(_0 -> in.ints()).sum();
        if (k < x) out.ans(-1).ln();
        else out.ans(Math.max(0, x)).ln();
    }
}
