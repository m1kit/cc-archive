package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BBeautifulHarmony {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int c = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) continue;
            if (c == 0) c = cnt[i];
            else if (c != cnt[i]) {
                out.noln();
                return;
            }
        }
        out.yesln();
    }
}
