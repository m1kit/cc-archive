package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ACards {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        char[] chars = in.string().toCharArray();
        int b0 = 0, b1 = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'z') {
                b0++;
            } else if (chars[i] == 'n') {
                b1++;
            }
        }
        for (int i = 0; i < b1; i++) {
            out.ans(1);
        }
        for (int i = 0; i < b0; i++) {
            out.ans(0);
        }
        out.ln();
    }
}
