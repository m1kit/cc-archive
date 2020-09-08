package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;

public class DAlexAndJulian {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long[] a = in.longs(n);
        int[] exp = new int[n];
        int[] cnt = new int[70];
        for (int i = 0; i < n; i++) {
            long t = a[i];
            while (t % 2 == 0) {
                exp[i]++;
                t /= 2;
            }
            cnt[exp[i]]++;
        }
        int maxcnt = IntMath.max(cnt);
        int dec = 0;
        for (int i = 0; i < 70; i++) {
            if (maxcnt == cnt[i]) dec = i;
        }
        out.ans(n - maxcnt).ln();
        for (int i = 0; i < n; i++) {
            if (exp[i] != dec) out.ans(a[i]);
        }
        out.ln();
    }
}
