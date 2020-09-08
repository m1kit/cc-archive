package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class AAirportBus {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), c = in.ints(), k = in.ints();
        int[] t = in.ints(n);
        IntroSort.sort(t);

        int limit = -1;
        int cnt = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] > limit || cnt == c) {
                limit = t[i] + k;
                cnt = 0;
                ans++;
            }
            cnt++;
        }
        out.ansln(ans);
    }
}
