package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BROTN {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        char[] s = in.string().toCharArray();
        for (int i = 0; i < s.length; i++) {
            s[i] = (char) ((s[i] - 'A' + 26 + n) % 26 + 'A');
        }
        out.ans(String.valueOf(s)).ln();
    }
}
