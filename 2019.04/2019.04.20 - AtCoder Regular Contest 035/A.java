package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        String s = in.string(), t = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' || t.charAt(i) == '*' || s.charAt(i) == t.charAt(i)) {
                continue;
            }
            out.noln();
            return;
        }
        out.yesln();
    }
}
