package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BReverseAndCompare {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        char[] s = in.string().toCharArray();
        int n = s.length;
        int[] cnt = new int[26];
        long ans = 1 + n * (n + 1L) / 2;
        for (char c : s) cnt[c - 'a']++;
        for (int i = 0; i < 26; i++) ans -= (cnt[i] + 1L) * cnt[i] / 2;
        out.ans(ans).ln();
    }
}
