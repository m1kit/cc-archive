package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class AHideAndSeek {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        int[] x = in.ints(k);
        int[] cnt = new int[n + 1], first = new int[n + 1], last = new int[n + 1];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        for (int i = 0; i < k; i++) {
            cnt[x[i]]++;
            if (first[x[i]] == -1) first[x[i]] = i;
            last[x[i]] = i;
        }
        int ans = 0;

        // (a, a)
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) ans++;
        }

        // (a, a + 1)
        for (int i = 1; i < n; i++) {
            if (cnt[i] == 0 || cnt[i + 1] == 0 || first[i] > last[i + 1]) ans++;
        }

        // (a + 1, a)
        for (int i = 1; i < n; i++) {
            if (cnt[i] == 0 || cnt[i + 1] == 0 || last[i] < first[i + 1]) ans++;
        }
        out.ans(ans).ln();
    }
}
