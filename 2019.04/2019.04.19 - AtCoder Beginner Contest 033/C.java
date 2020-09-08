package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String[] s = in.string().split("\\+");
        int c = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].contains("0")) {
                c++;
            }
        }
        out.ansln(s.length - c);
    }
}
