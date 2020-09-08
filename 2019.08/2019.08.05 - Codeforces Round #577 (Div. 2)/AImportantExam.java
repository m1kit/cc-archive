package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AImportantExam {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        String[] choices = in.string(n);
        int[] score = in.ints(m);
        long ans = 0;
        for (int i = 0; i < m; i++) {
            int[] cnt = new int[5];
            for (int j = 0; j < n; j++) {
                cnt[choices[j].charAt(i) - 'A']++;
            }
            int max = 0;
            for (int j = 0; j < 5; j++) {
                max = Math.max(max, cnt[j]);
            }
            ans += max * score[i];
        }
        out.ans(ans).ln();
    }
}
