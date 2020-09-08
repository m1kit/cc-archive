package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DPreparingBoxes {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int cnt = 0;
        int[] ans = new int[n];
        for (int i = n; i >= 1; i--) {
            int c = 0;
            for (int j = i; j <= n; j += i) if (ans[j - 1] == 1) c++;
            if (a[i - 1] == c % 2) continue;
            cnt++;
            ans[i - 1] = 1;
        }
        out.ans(cnt).ln();
        for (int i = 1; i <= n; i++) if (ans[i - 1] == 1) out.ans(i);
        out.ln();
    }
}
