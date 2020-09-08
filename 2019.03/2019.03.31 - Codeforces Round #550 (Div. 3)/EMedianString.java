package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class EMedianString {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int k = in.ints();
        String s = in.string(), t = in.string();
        int[] ans = new int[k + 1];
        for (int i = 0; i < k; i++) {
            ans[k - i - 1] += s.charAt(i) - 'a';
            ans[k - i - 1] += t.charAt(i) - 'a';
        }

        for (int i = 0; i <= k; i++) {
            if (ans[i] % 2 == 0) {
                ans[i] /= 2;
            } else {
                ans[i - 1] += 13;
                ans[i] /= 2;
            }
        }
        for (int i = 0; i < k; i++) {
            if (ans[i] >= 26) {
                ans[i] -= 26;
                ans[i + 1] += 1;
            }
        }
        for (int i = 0; i < k; i++) {
            out.print((char) (ans[k - i - 1] + 'a'));
        }
        out.ln();
    }
}
