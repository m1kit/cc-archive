package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int[] cnt = new int[26];
        String s = in.string();
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int odd = 0, even = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                odd++;
            }
            even += cnt[i] / 2;
        }
        if (odd == 0) {
            out.ans(even * 2).ln();
        } else {
            out.ans(even / odd * 2 + 1).ln();
        }
    }
}
