package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class D {

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        String s = in.string();
        char[] chr = "abcdefghijklmnopqrstuvwxyz.".toCharArray();
        int ans = 0;
        for (char x : chr) {
            if (s.matches(".*" + x + ".*")) ans++;
            for (char y : chr) {
                if (s.matches(".*" + x + y + ".*")) ans++;
                for (char z : chr) {
                    if (s.matches(".*" + x + y + z + ".*")) ans++;
                }
            }
        }
        out.ans(ans).ln();
    }
}
