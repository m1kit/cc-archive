package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class APaintTheNumbers {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        IntroSort.sort(a);
        boolean[] done = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (done[i]) continue;
            int d = a[i];
            ans++;
            for (int j = 0; j < n; j++) {
                if (a[j] % d == 0) {
                    done[j] = true;
                }
            }
        }
        out.ans(ans).ln();
    }
}
