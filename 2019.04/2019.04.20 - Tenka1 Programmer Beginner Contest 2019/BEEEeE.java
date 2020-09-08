package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BEEEeE {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String s = in.string();
        int k = in.ints() - 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s.charAt(k)) {
                out.print(s.charAt(i));
            } else {
                out.print('*');
            }
        }
        out.ln();
    }
}
