package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class CBirthday {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        IntroSort.sort(a);
        for (int i = 0; i < n; i+=2)  out.ans(a[i]);
        for (int i = n % 2 == 0 ? n - 1 : n - 2; i >= 0; i -= 2) out.ans(a[i]);
        out.ln();
    }
}
