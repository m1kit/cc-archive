package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CSubstringGameInTheLesson {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        char[] s = in.string().toCharArray();
        int n = s.length;
        int min = 1000;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, s[i]);
            if (min == s[i]) {
                out.ans("Mike").ln();
            } else {
                out.ans("Ann").ln();
            }
        }
    }
}
