package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class EStringsOfImpurity {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string(), t = in.string();
        int n = s.length(), m = t.length();
        int[][] index = new int[26][n];
        for (int i = 0; i < 26; i++) index[i][0] = Integer.MIN_VALUE;
        for (int i = 2 * n - 1; i >= 0; i--) {
            int now = i % n, nxt = (now + 1) % n;
            for (int j = 0; j < 26; j++) {
                index[j][now] = index[j][nxt] + 1;
            }
            index[s.charAt(now) - 'a'][now] = 0;
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            int d = index[t.charAt(i) - 'a'][(int) (ans % n)];
            //System.out.println("t[" + i + "]=" + t.charAt(i) + " cur=" + (ans % n) + " d=" + d);
            if (d < 0) {
                out.ans(-1).ln();
                return;
            }
            ans += d + 1;
        }
        out.ans(ans).ln();
    }
}
