package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] cnt = new int[5];
        int ans = 1;
        int rid = in.ints();
        int rem = n - 1;
        for (int i = 1; i < n; i++) {
            cnt[in.ints()]++;
        }

        outer: while (rem > 0) {
            for (int i = 4 - rid; i >= 1; i--) {
                if (cnt[i] > 0) {
                    //System.out.println("Taking " + i + " to " + ans);
                    rem--;
                    cnt[i]--;
                    rid += i;
                    continue outer;
                }
            }
            ans++;
            rid = 0;
        }

        out.ans(ans).ln();
    }
}
