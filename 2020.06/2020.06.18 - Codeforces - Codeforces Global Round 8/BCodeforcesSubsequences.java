package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class BCodeforcesSubsequences {

    private static final int C = 1 << 10;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        long k = in.longs();
        int[] cnt = new int[10];
        Arrays.fill(cnt, 1);
        long prod = 1;
        while (prod < k) {
            int mind = 0;
            for (int i = 0; i < 10; i++) {
                if (cnt[i] <= cnt[mind]) mind = i;
            }
            prod /= cnt[mind];
            prod *= ++cnt[mind];
        }
        char[] cf = "codeforces".toCharArray();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < cnt[i]; j++) out.print(cf[i]);
        }
        out.ln();
    }
}
