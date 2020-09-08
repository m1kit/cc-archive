package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BHateA {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String t = in.string();
        String rep = t.replace("a", "");
        String most = rep.substring(0, rep.length() / 2), least = rep.substring(rep.length() / 2);
        if (!most.equals(least)) {
            out.ans(":(").ln();
            return;
        }
        int right = 0;
        for (int i = 0; i < most.length(); i++) {
            while (t.charAt(right) != most.charAt(i)) {
                right++;
            }
            right++;
        }
        while (right < t.length() && t.charAt(right) == 'a') {
            right++;
        }
        String s = t.substring(0, right);
        String sd = t.substring(right);
        for (int i = 0; i < sd.length(); i++) {
            if (sd.charAt(i) == 'a') {
                out.ans(":(").ln();
                return;
            }
        }
        out.ans(s).ln();
    }
}
