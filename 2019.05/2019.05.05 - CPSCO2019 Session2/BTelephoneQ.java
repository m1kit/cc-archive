package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BTelephoneQ {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int base = 0;
        int mult = 1;
        int n = in.ints();
        for (int i = 0; i < n; i++) {
            char c = in.string().charAt(0);
            int a = in.ints();
            if (c == '+') {
                base += a;
            } else if (c == '*' && a > 0) {
                mult *= a;
            }
        }
        out.ans(base * mult).ln();
    }
}
