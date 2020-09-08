package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class BParityAlternatedDeletions {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        int[] cnt = new int[2];
        IntroSort.sort(a);
        for (int i = 0; i < n; i++) {
            cnt[a[i] % 2]++;
        }

        if (Math.abs(cnt[0] - cnt[1]) <= 1) {
            out.ansln(0);
        } else if (cnt[0] < cnt[1]) {
            long ans = 0;
            for (int i = 0, j = 1; j < cnt[1] - cnt[0]; i++) {
                if (a[i] % 2 == 1) {
                    ans += a[i];
                    j++;
                }
            }
            out.ansln(ans);
        } else {
            long ans = 0;
            for (int i = 0, j = 1; j < cnt[0] - cnt[1]; i++) {
                if (a[i] % 2 == 0) {
                    ans += a[i];
                    j++;
                }
            }
            out.ansln(ans);
        }
    }
}
