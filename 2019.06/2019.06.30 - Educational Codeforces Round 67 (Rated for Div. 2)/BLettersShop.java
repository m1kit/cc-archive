package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BLettersShop {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String s = in.string();
        int[][] a = new int[26][n + 1];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j + 1] = a[i][j] + (s.charAt(j) - 'a' == i ? 1 : 0);
            }
        }

        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int[] cnt = new int[26];
            for (char c : in.string().toCharArray()) {
                cnt[c - 'a']++;
            }
            int min = 0, max = n;
            loop: while (max - min > 1) {
                int mid = (min + max + 1) / 2;
                for (int i = 0; i < 26; i++) {
                    if (cnt[i] > a[i][mid]) {
                        min = mid;
                        continue loop;
                    }
                }
                max = mid;
            }
            out.ans(max).ln();
        }
    }
}
