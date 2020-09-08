package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DGatheringChildren {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int n = s.length();
        int[] ans = new int[n];
        int cur = 0;
        while (cur < n) {
            int leftStart = cur;
            int rightStart = leftStart;
            while (s.charAt(rightStart) == 'R') rightStart++;
            cur = rightStart;
            while (cur < n && s.charAt(cur) == 'L') cur++;
            int[] cnt = new int[2];
            for (int i = leftStart; i < cur; i++) cnt[i % 2]++;
            if (rightStart % 2 == 0) {
                ans[rightStart - 1] = cnt[1];
                ans[rightStart] = cnt[0];
            } else {
                ans[rightStart - 1] = cnt[0];
                ans[rightStart] = cnt[1];
            }
        }
        for (int i = 0; i < n; i++) {
            out.ans(ans[i]);
        }
        out.ln();
    }
}
