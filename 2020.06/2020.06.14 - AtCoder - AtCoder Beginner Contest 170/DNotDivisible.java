package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class DNotDivisible {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long ans = 0;
        int[] a = in.ints(n);
        boolean[] ng = new boolean[1_000_001];
        IntroSort.sort(a);
        for (int i = 0; i < n; i++) {
            if (ng[a[i]]) continue;
            for (int j = a[i]; j <= 1_000_000; j += a[i]) ng[j] = true;
            if (i < n - 1 && a[i] == a[i + 1]) continue;
            ans++;
        }
        out.ans(ans).ln();
    }
}
