package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class CDubiousDocument {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String[] s = in.string(n);

        int[] cnt = new int[26];
        Arrays.fill(cnt, 50);

        for (int i = 0; i < n; i++) {
            int[] c = new int[26];
            for (int j = 0; j < s[i].length(); j++) {
                c[s[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                cnt[j] = Math.min(cnt[j], c[j]);
            }
        }
        //System.out.println(Arrays.toString(cnt));
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                out.print((char) ('a' + i));
            }
        }
        out.ln();
    }
}
