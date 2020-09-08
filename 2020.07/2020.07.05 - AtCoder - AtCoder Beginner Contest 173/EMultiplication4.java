package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.mod.ModMath;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class EMultiplication4 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints();
        Long[] a = new Long[n];
        int[] cnt = new int[3];
        ModMath mod = new ModMath(MOD);
        for (int i = 0; i < n; i++) {
            a[i] = in.longs();
            cnt[Long.signum(a[i]) + 1]++;
        }
        if (n == k) {
            long ans = 1;
            for (int i = 0; i < n; i++) {
                ans *= a[i] + MOD;
                ans %= MOD;
            }
            out.ans(ans).ln();
        } else if (cnt[2] == 0 && k % 2 == 1) {
            IntroSort.sort(a, Comparator.comparing(Math::abs));
            long ans = 1;
            for (int i = 0; i < k; i++) {
                ans *= MOD + a[i];
                ans %= MOD;
            }
            out.ans(ans).ln();
        } else {
            // positive
            IntroSort.sort(a, Comparator.comparing(x -> -Math.abs(x)));
            long ans = 1;
            int sgn = 1;
            long posmin = Long.MAX_VALUE, negmin = Long.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                if (a[i] >= 0) posmin = Math.min(posmin, a[i]);
                else negmin = Math.min(negmin, -a[i]);
                ans *= Math.abs(a[i]);
                ans %= MOD;
                sgn *= Long.signum(a[i]);
            }
            if (sgn >= 0) {
                out.ans(ans).ln();
                return;
            }
            long posmax = 0, negmax = 0;
            for (int i = k; i < n; i++) {
                if (a[i] >= 0) posmax = Math.max(posmax, a[i]);
                else negmax = Math.max(negmax, -a[i]);
            }
            if (negmax == 0 || posmin == Long.MAX_VALUE || posmax * posmin >= negmax * negmin) {
                ans *= mod.inv(negmin) * posmax % MOD;
                ans %= MOD;
            } else {
                ans *= mod.inv(posmin) * negmax % MOD;
                ans %= MOD;
            }
            out.ans(ans).ln();
        }
    }
}
