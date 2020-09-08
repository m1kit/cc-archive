package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BEmailFromPolycarp {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int testCases = in.ints();
        loop: for (int testCase = 0; testCase < testCases; testCase++) {
            String s = in.string(), t = in.string();
            int n = s.length(), m = t.length();
            int cur = 0;
            char last = '*';
            for (int i = 0; i < m; i++) {
                if (cur < n && t.charAt(i) == s.charAt(cur)) {
                    last = s.charAt(cur++);
                } else if (t.charAt(i) != last) {
                    out.noln();
                    continue loop;
                }
            }
            out.ans(cur == n).ln();
        }
    }
}
