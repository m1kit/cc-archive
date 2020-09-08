package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class CSimilarPairs {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints();
            int[] cnt = new int[2], a = in.ints(n);
            IntroSort.sort(a);
            boolean ok = false;
            for (int i = 0; i < n; i++) cnt[a[i] % 2]++;
            for (int i = 1; i < n; i++) if (a[i] - a[i - 1] == 1) ok = true;
            if (cnt[0] % 2 == 0) ok = true;
            out.ans(ok).ln();
        }
    }
}
