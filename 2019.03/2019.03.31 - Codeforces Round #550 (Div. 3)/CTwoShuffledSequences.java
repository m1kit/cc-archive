package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class CTwoShuffledSequences {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        IntroSort.sort(a);
        boolean[] which = new boolean[n];
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] == a[i]) {
                if (which[i - 1]) {
                    out.noln();
                    return;
                }
                which[i] = true;
                cnt++;
            }
        }
        out.yesln();
        out.ansln(n - cnt);
        for (int i = 0; i < n; i++) {
            if (!which[i]) {
                out.ans(a[i]);
            }
        }
        out.ln().ansln(cnt);
        for (int i = n - 1; i >= 0; i--) {
            if (which[i]) {
                out.ans(a[i]);
            }
        }
        out.ln();
    }
}
