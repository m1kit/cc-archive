package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ADistinctDigits {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int l = in.ints(), r = in.ints();
        for (int i = l; i <= r; i++) {
            String str = Integer.toString(i);
            if (str.length() == str.chars().distinct().count()) {
                out.ans(str).ln();
                return;
            }
        }
        out.ans(-1).ln();
    }
}
