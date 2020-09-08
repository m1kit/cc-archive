package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CDubiousDocument2 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string(), t = in.string();
        outer: for (int i = s.length() - t.length(); i >= 0; i--) {
            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '?') {
                    ans.append('a');
                } else {
                    ans.append(s.charAt(j));
                }
            }
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i + j) != '?' && s.charAt(i + j) != t.charAt(j)) {
                    continue outer;
                }
            }
            ans.append(t);
            for (int j = i + t.length(); j < s.length(); j++) {
                if (s.charAt(j) == '?') {
                    ans.append('a');
                } else {
                    ans.append(s.charAt(j));
                }
            }
            out.ansln(ans.toString());
            return;
        }
        out.ansln("UNRESTORABLE");
    }
}
