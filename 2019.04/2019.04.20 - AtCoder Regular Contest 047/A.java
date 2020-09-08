package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), l = in.ints();
        String s = in.string();
        int cnt = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '+') {
                cnt++;
                if (cnt > l) {
                    cnt = 1;
                    ans++;
                }
            } else {
                cnt--;
            }
        }
        out.ans(ans).ln();
    }
}
