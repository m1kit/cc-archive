package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class BKillEmAll {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int q = in.ints();
        for (int testcase = 0; testcase < q; testcase++) {
            int n = in.ints(), r = in.ints();
            int[] a = in.ints(n);
            IntroSort.sort(a);
            int d = 0;
            int last = -1;
            int ans = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (a[j] == last) continue;
                if (a[j] - d > 0) {
                    ans++;
                    d += r;
                    last = a[j];
                } else break;
            }
            out.ans(ans).ln();
        }
    }
}
