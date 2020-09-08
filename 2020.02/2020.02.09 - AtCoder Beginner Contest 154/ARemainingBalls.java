package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ARemainingBalls {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String x = in.string();
        in.voids();
        int a = in.ints(), b = in.ints();
        if (in.string().equals(x)){
            a--;
        } else {
            b--;
        }
        out.ans(a).ans(b).ln();
    }
}
