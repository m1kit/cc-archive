package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ARace {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String s = in.string();
        int[] left = new int[n + 1], right = new int[n + 1];
        for (int i = 0; i < n; i++) {
            left[i + 1] =  s.charAt(i) == '>' ? (left[i] + 1) : 0;
            right[n - i - 1] = s.charAt(n - i - 1) == '>' ? (right[n - i] +1) : 0;
        }
        int max = -1, idx = -1;
        for (int i = 0; i < n; i++) {
            int val = left[i] + right[i + 1];
            if (val > max) {
                max = val;
                idx = i;
            }
        }
        String t = s.substring(0, idx) + ">" + s.substring(idx + 1);
        double ans = 0;
        int trail = 0;
        for (int i = 0; i < n; i++) {
            if (t.charAt(i) == '-') {
                trail = 0;
                ans += 1.0;
            } else {
                ans += 1.0 / (trail + 2.0);
                trail += 1.0;
            }
        }
        out.ans(ans, 10).ln();
    }
}
