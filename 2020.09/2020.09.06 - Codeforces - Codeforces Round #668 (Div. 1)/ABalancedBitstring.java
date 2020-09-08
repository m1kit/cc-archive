package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter2;

public class ABalancedBitstring {

    private static final int MOD = (int) 1e9 + 7;
    private static final long INF = 1_000_000_000_000_000_000L;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        out.setBoolLabel(LightWriter2.BoolLabel.YES_NO_ALL_UP);
        int testCases = in.ints();
        test:
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints(), k = in.ints();
            char[] s = in.chars();
            for (int i = k; i < n; i++) {
                if (s[i] != '?' && s[i - k] != '?' && s[i - k] != s[i]) {
                    out.noln();
                    continue test;
                }
                if (s[i] == '?') s[i] = s[i - k];
                if (s[i - k] == '?') s[i - k] = s[i];
            }
            //System.out.println(String.valueOf(s));
            int c0 = 0, c1 = 0, ca = 0;
            for (int i = 0; i < k; i++) {
                if (s[i] == '0') c0++;
                else if (s[i] == '1') c1++;
                else ca++;
            }
            boolean cond = c0 + ca >= c1 && c0 <= c1 + ca;
            for (int i = k; i < n; i++) {
                if (s[i - k] == '0') c0--;
                else if (s[i - k] == '1') c1--;
                else ca--;
                if (s[i] == '0') c0++;
                else if (s[i] == '1') c1++;
                else ca++;
                cond &= c0 + ca >= c1 && c0 <= c1 + ca;
            }
            out.ans(cond).ln();
        }
    }
}
