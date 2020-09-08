package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BKoalaAndLights {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        char[] s = in.string().toCharArray();
        int[] a = new int[n], b = new int[n];
        in.ints(a, b);
        int ans = 0;
        for (int t = 0; t < 100000; t++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (b[i] == 0) {
                    s[i] = s[i] == '0' ? '1' : '0';
                    b[i] = a[i];
                }
                b[i]--;
                cnt += s[i] - '0';
            }
            ans = Math.max(ans, cnt);
        }
        out.ans(ans).ln();
    }
}
