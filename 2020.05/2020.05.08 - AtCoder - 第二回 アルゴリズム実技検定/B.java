package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        char[] s = in.chars();
        int[] cnt = new int[128];
        for (char x : s) cnt[x]++;
        if (cnt['a'] > cnt['b'] && cnt['a'] > cnt['c']) out.ans('a').ln();
        if (cnt['b'] > cnt['c'] && cnt['b'] > cnt['a']) out.ans('b').ln();
        if (cnt['c'] > cnt['a'] && cnt['c'] > cnt['b']) out.ans('c').ln();
    }
}
