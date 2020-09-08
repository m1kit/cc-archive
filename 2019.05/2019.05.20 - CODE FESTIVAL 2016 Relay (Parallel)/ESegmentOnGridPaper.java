package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class ESegmentOnGridPaper {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int a = in.ints(), b = in.ints(), c = in.ints(), d = in.ints();
        long x = Math.abs(a - c), y = Math.abs(b - d);
        long m = IntMath.gcd(x, y);
        x /= m;
        y /= m;
        out.ans((x + y - 1) * m).ln();
    }
}
