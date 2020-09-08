package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BSumo {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        String s = in.string();
        int cnt = 15 - s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'o') cnt++;
        }
        out.ans(cnt >= 8).ln();
    }
}
