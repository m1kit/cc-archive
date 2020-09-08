package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class C1MadhouseEasyVersion {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        out.enableAutoFlush();
        int m = in.ints(), n = (m + 1) / 2;
        char[] p1 = guess(in, out, 1, n);
        char[] ans = new char[m];
        if (n == 1) {
            ans[0] = p1[0];
        } else {
            char[] p2 = guess(in, out, 1, n - 1);
            int[] cnt = new int[26];
            for (int i = 0; i < n; i++) cnt[p1[i] - 'a']++;
            for (int i = 0; i < n - 1; i++) cnt[p2[i] - 'a']--;
            for (int i = 0; i < 26; i++) if (cnt[i] > 0) ans[n - 1] = (char) (i + 'a');
            for (int i = 0; i < n / 2; i++) {
                if (ans[n - i - 1] != p1[n - i - 1]) ArrayUtil.swap(p1, i, n - i - 1);
                ans[i] = p1[i];
                if (ans[i] != p2[i]) ArrayUtil.swap(p2, i, n - i - 2);
                ans[n - i - 2] = p2[n - i - 2];
            }
        }

        char[] p3 = guess(in, out, 1, m);
        for (int i = 0; i < n; i++) {
            if (p3[i] != ans[i]) ArrayUtil.swap(p3, i, m - i - 1);
        }


        out.ans('!').ans(String.valueOf(p3)).ln();
    }

    /*private static char[] guess(LightScanner in, LightWriter out, int from, int to) {
        System.out.println("QUERY ISSUED: [" + from + ", " + to + "]");
        String ans = "bba";
        char[] sub = ans.substring(from - 1, to).toCharArray();
        int len = sub.length;
        for (int i = 0; i < len / 2; i++) {
            if (Math.random() < 0.5) {
                ArrayUtil.swap(sub, i, len - i - 1);
            }
        }
        return sub;
    }
    //*/

    //*
    private static char[] guess(LightScanner in, LightWriter out, int from, int to) {
        int n = to - from + 1;
        if (n == 0) return new char[0];

        out.ans('?').ans(from).ans(to).ln();
        int n2 = (n + 1) / 2;
        int[][] cnt = new int[26][n + 1];
        for (int i = 0; i < n * (n + 1) / 2; i++) {
            char[] s = in.string().toCharArray();
            if (s.length < n2) continue;
            for (char c : s) cnt[c - 'a'][s.length]++;
        }
        for (int i = n2; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                cnt[j][i] -= cnt[j][i + 1];
            }
        }
        for (int i = n; i >= n2 + 1; i--) {
            for (int j = 0; j < 26; j++) {
                cnt[j][i] -= cnt[j][i - 1];
            }
        }

        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            int ref = Math.max(n - i, i + 1);
            for (int j = 0; j < 26; j++) {
                if (cnt[j][ref] > 0) {
                    cnt[j][ref]--;
                    ans[i] = (char) ('a' + j);
                    break;
                }
            }
        }
        return ans;
    }
    //*/
}
