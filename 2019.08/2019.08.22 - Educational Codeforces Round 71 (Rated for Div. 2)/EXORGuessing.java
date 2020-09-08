package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class EXORGuessing {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        out.print('?');
        for (int i = 0; i < 100; i++) {
            out.ans(i + 1);
        }
        out.ln().flush();
        int most = in.ints() & 0b11111110000000;

        out.print('?');
        for (int i = 0; i < 100; i++) {
            out.ans((i + 1) << 7);
        }
        out.ln().flush();
        int least = in.ints() & 0b00000001111111;

        out.print('!').ans(most | least).ln().flush();
    }
}
