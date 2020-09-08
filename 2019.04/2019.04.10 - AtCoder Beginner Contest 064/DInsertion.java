package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DInsertion {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String s = in.string();

        int depth = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                if (depth < 0) {
                    left = Math.max(left, -depth);
                }
            }
        }
        while (left > 0) {
            out.print('(');
            left--;
            depth++;
        }
        out.print(s);
        while (depth > 0) {
            out.print(')');
            depth--;
        }
        out.ln();
    }
}
