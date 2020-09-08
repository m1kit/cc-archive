package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int ans = 0;
        for (String x : new String[]{s, s.substring(1)}) {
            int streak = 0;
            boolean two = false;
            for (int i = 0; i < x.length(); i++) {
                if (i % 2 == 0 && (x.charAt(i) == '2' || x.charAt(i) == '?')) {
                    two = true;
                } else if (i % 2 == 1 && two && (x.charAt(i) == '5' || x.charAt(i) == '?')) {
                    two = false;
                    streak++;
                } else {
                    ans = Math.max(ans, streak);
                    streak = 0;
                    two = false;
                }
            }
            ans = Math.max(ans, streak);
        }
        out.ansln(ans * 2);
    }
}
