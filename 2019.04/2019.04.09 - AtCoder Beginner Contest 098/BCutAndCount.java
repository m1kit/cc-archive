package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BCutAndCount {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String s = in.string();
        int a = 0;
        for (int i = 0; i <= s.length(); i++) {
            String x = s.substring(0, i), y = s.substring(i);
            int[][] cnt = new int[2][26];
            for (int j = 0; j < x.length(); j++) {
                cnt[0][x.charAt(j) - 'a']++;
            }
            for (int j = 0; j < y.length(); j++) {
                cnt[1][y.charAt(j) - 'a']++;
            }
            int ans = 0;
            for (int j = 0; j < 26; j++) {
                if (cnt[0][j] > 0 && cnt[1][j] > 0) {
                    ans++;
                }
            }
            a = Math.max(a, ans);
        }
        out.ansln(a);
    }
}
