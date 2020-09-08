package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class EWhoSaysAPun {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String s = in.string();

        if (s.substring(0, n / 2).equals(s.substring(n / 2, n))) {
            out.ans(n / 2).ln();
            return;
        }

        int maxlen = 0, curlen = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                if (curlen > maxlen) {
                    maxlen = curlen;
                }
                curlen = 1;
            } else {
                curlen++;
            }
        }
        if (curlen > maxlen) {
            maxlen = curlen;
        }
        if (2 * maxlen >= n) {
            out.ans(maxlen / 2).ln();
            return;
        }


        Substring substr = new Substring(s);
        List<Integer> bucket = new ArrayList<>();
        for (int i = 0; i <= n; i++) bucket.add(i);
        bucket.sort(substr::compare);
        int max = 0;
        for (int t = 0; t < 100; t++) {
            for (int i = t; i < n; i++) {
                int cnt = 0;
                int x = bucket.get(i - t), y = bucket.get(i + 1);
                int len = n - Math.max(x, y);
                for (int j = 0; j < Math.min(len, Math.abs(x - y)); j++) {
                    if (s.charAt(x + j) != s.charAt(y + j)) break;
                    cnt++;
                }
                if (cnt > max) {
                    max = cnt;
                }
            }
        }
        if (max == 0) {
            out.ans(0).ln();
        } else {
            out.ans(max).ln();
        }
    }

    private static class Substring {
        private int n;
        private String base;

        Substring(String base) {
            this.n = base.length();
            this.base = base;
        }

        private int compare(int i, int j) {
            if (i == n && j == n) {
                return 0;
            } else if (i == n) {
                return -1;
            } else if (j == n) {
                return 1;
            } else if (base.charAt(i) == base.charAt(j)) {
                return compare(i + 1, j + 1);
            } else if (base.charAt(i) < base.charAt(j)) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
