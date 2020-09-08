package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BQualificationSimulator {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), a = in.ints(), b = in.ints();
        String s = in.string();
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b' && x + y < a + b && y < b) {
                y++;
                out.yesln();
            } else if (s.charAt(i) == 'a' && x + y < a + b) {
                x++;
                out.yesln();
            } else {
                out.noln();
            }
        }
    }
}
