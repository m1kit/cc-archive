package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class CMakeATeam {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), d = in.ints();
        int[] a = in.ints(n);
        IntroSort.sort(a);

        long ans = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            while (a[r] - a[l] > d) {
                l++;
            }
            ans += (r - l - 1L) * (r - l) / 2;
        }
        out.ans(ans).ln();
    }
}
