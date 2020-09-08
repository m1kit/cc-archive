package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.Map;

public class EGluttony {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long k = in.longs();
        long[] a = in.longs(n), f = in.longs(n);
        Arrays.sort(a);
        Arrays.sort(f);

        long ng = -1, ok = 1_000_000_000_000L;
        while (ok - ng > 1) {
            long mid = (ok + ng) / 2, times = 0;
            for (int i = 0; i < n; i++) times += Math.max(0, a[i] - mid / f[n - i - 1]);
            if (times > k) ng = mid;
            else ok = mid;
        }
        out.ans(ok).ln();
    }
}
