package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ADiverseStrings {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        outer: for (int i = 0; i < n; i++) {
            String s = in.string();
            int[] cnt = new int[26];
            int min = 26, max = -1;
            for (int j = 0; j < s.length(); j++) {
                int cp = s.charAt(j) - 'a';
                if (++cnt[cp] > 1) {
                    out.noln();
                    continue outer;
                }
                min = Math.min(min, cp);
                max = Math.max(max, cp);
            }
            out.ansln(max - min + 1 == s.length());
        }
    }
}
