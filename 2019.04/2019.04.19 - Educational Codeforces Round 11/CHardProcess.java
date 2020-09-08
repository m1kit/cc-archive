package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CHardProcess {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        int[] a = in.ints(n);
        int l = 0;
        int c = 0;
        int ans = 0, ansl = -1, ansr = -1;
        for (int r = 0; r < n; r++) {
            if (a[r] == 0) {
                c++;
            }
            while (c > k) {
                if (a[l] == 0) {
                    c--;
                }
                l++;
            }
            if (r - l + 1 > ans) {
                ansl = l;
                ansr = r;
                ans = r - l + 1;
            }
        }
        out.ans(ans).ln();
        for (int i = 0; i < n; i++) {
            if (ansl <= i && i <= ansr) {
                out.ans(1);
            } else {
                out.ans(a[i]);
            }
        }
        out.ln();
    }
}
