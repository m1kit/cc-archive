package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BConcatenatedPalindrome {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        outer: for (int i = 0; i <= s.length(); i++) {
            StringBuilder sb = new StringBuilder(s.substring(0, i));
            sb.reverse();
            String t = s + sb.toString();
            int l = 0, r = t.length() - 1;
            while (l < r) {
                if (t.charAt(l) != t.charAt(r)) {
                    continue outer;
                }
                l++;
                r--;
            }
            out.ansln(i);
            return;
        }
        throw new RuntimeException();
    }
}
