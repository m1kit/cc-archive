package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string()
                .replace('O', '0')
                .replace('D', '0')
                .replace('I', '1')
                .replace('Z', '2')
                .replace('S', '5')
                .replace('B', '8');
        out.ans(s).ln();
    }
}
