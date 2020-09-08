package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ForegoneSolution {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        StringBuilder s = new StringBuilder(), t = new StringBuilder();
        String n = in.string();
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '4') {
                s.append('3');
                t.append('1');
            } else {
                s.append(n.charAt(i));
                if (t.length() > 0) {
                    t.append('0');
                }
            }
        }
        if (t.length() == 0) {
            t.append('0');
        }
        out.ans("Case #" + testNumber + ":").ans(s).ans(t).ln();
    }
}
