package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DKatanaThrower {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long h = in.longs();
        long[] b = new long[n];
        long max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(in.longs(), max);
            b[i] = in.longs();
        }
        IntroSort.sort(b);
        int cur = n - 1;
        long ans = 0;
        while (cur >= 0 && h > 0 && b[cur] > max) {
            h -= b[cur];
            cur--;
            ans++;
        }
        if (h > 0)
            ans += (h + max - 1) / max;
        out.ans(ans).ln();
    }
}
