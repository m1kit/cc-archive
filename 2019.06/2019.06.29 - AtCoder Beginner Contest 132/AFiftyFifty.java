package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AFiftyFifty {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        char[] cnt = new char[26];
        for (char c : in.string().toCharArray()) {
            cnt[c - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] != 2) {
                out.noln();
                return;
            }
        }
        out.yesln();
    }
}
